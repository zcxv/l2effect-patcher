package m0nster.efpatcher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import acmi.l2.clientmod.unreal.core.ByteProperty;
import m0nster.efpatcher.patch.BytePatch;
import m0nster.efpatcher.patch.EnumPatch;
import m0nster.efpatcher.patch.NamePatch;
import m0nster.efpatcher.patch.ObjectPatch;
import m0nster.efpatcher.patch.Patch;
import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.io.DataOutputStream;
import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.io.UnrealPackageFile.Entry;
import acmi.l2.clientmod.io.UnrealPackageFile.ExportEntry;
import acmi.l2.clientmod.unreal.classloader.FolderPackageLoader;
import acmi.l2.clientmod.unreal.classloader.L2Property;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil.Type;
import acmi.l2.clientmod.unreal.classloader.UnrealClassLoader;
import acmi.l2.clientmod.unreal.objectfactory.AsIsObject;
import acmi.l2.clientmod.unreal.objectfactory.ObjectFactory;

/**
 * @author PointerRage
 *
 */
public class Starter {
	private final static Consumer<? super Entry> view = entry -> System.out.println(entry.getObjectInnerFullName());

	public static void main(String...args) throws Throwable {
		String reqObjectName = "mb.SkillAction_LocateEffect0";
		String reqField = "AttachOn";
		String replace = "EAM_BoneSpecified";
		String file = "skill.usk";
		boolean showAll = false;
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equals("-show")) {
				showAll = true;
				break;
			} else if(args[i].equals("-object")) {
				reqObjectName = args[++i];
			} else if(args[i].equals("-field")) {
				reqField = args[++i];
			} else if(args[i].equals("-replace")) {
				replace = args[++i];
			} else if(args[i].equals("-file")) {
				file = args[++i];
			}
		}
		
		String folder = "./import";
		File skillFile = new File(folder, file);
		UnrealClassLoader classLoader = new UnrealClassLoader(new FolderPackageLoader(new File(folder)));
		if(showAll) {
			try (UnrealPackageFile upf = new UnrealPackageFile(skillFile, true)) {
				System.out.println("-- IMPORTS");
				upf.getImportTable().forEach(view);
				System.out.println("-- EXPORTS");
				upf.getExportTable().forEach(view);
				
				out("-- Read depends");
				ObjectFactory oFactory = new ObjectFactory(classLoader);
				final String objectName = reqObjectName;
				AsIsObject uobj = upf.getExportTable().stream().
						filter(entry -> entry.getObjectInnerFullName().equals(objectName)).findAny().
						map(oFactory).map(raw -> (AsIsObject)raw).orElse(null);
					
				if(uobj == null) {
					out("Object not found");
					return;
				}
				out("-----------");
				
				out(uobj.getEntry().getObjectInnerFullName());
				out(Util.printData(uobj.getEntry().getObjectRawDataExternally()));
				
				List<L2Property> properties = uobj.getProperties();
				for(L2Property prop : properties) {
					out("\t" + prop.toString());
					if(Util.isReferenced(prop.getType())) {
						int offset = (int)prop.getAt(0);
						if(prop.getType() == Type.NAME) {
							out(offset + "=" + upf.nameReference(offset));
						} else {
							Entry ref = upf.objectReference(offset);
							out(offset + "=" + ref.toString());
						}
					}
				}
			}
			return;
		}
		
		File backupFile = new File(folder, "skill.usk_backup");
		Files.copy(skillFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		ObjectFactory oFactory = new ObjectFactory(classLoader);
		
		try (UnrealPackageFile upf = new UnrealPackageFile(skillFile, false)) {
			out("-- Read depends");
			final String objectName = reqObjectName;
			
			List<AsIsObject> exports = upf.getExportTable().stream()
				.map(oFactory)
				.filter(e -> e instanceof AsIsObject)
				.map(e -> (AsIsObject)e)
				.collect(Collectors.toList());
			
			AsIsObject uobj = Util.findExport(exports, objectName);	
			if(uobj == null) {
				out("Object not found");
				return;
			}
			out("-----------");
			
			out(uobj.getEntry().getObjectInnerFullName());
			out(Util.printData(uobj.getEntry().getObjectRawDataExternally()));
			
			List<L2Property> properties = uobj.getProperties();
			for(L2Property prop : properties) {
				if(prop.getName().equals(reqField)) {
					out("\t" + prop.toString());
					Patch patch = createPatch(prop, classLoader);
					patch.setObjects(exports);
					try {
						patch.patch(upf, prop, replace);
					} catch(RuntimeException e) {
						out("Fail: " + e.getMessage());
						return;
					}
					out("OK");
					break;
				}
			}
			
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutput dao = new DataOutputStream(baos, upf.getCharset());
				classLoader.getPropertiesUtil().writeProperties(dao, properties, upf);
				out(Util.printData(baos.toByteArray()));
				((ExportEntry)uobj.getEntry()).setObjectRawData(baos.toByteArray(), true);
			}
			
			upf.reload();
		}
	}
	
	private static Patch createPatch(L2Property property, UnrealClassLoader classLoader) {
		switch (property.getType()) {
		case OBJECT:
			return new ObjectPatch();
		case BYTE:
			if(((ByteProperty)property.getTemplate()).getEnumType() != null) {
				return new EnumPatch(classLoader);
			}
			return new BytePatch();
		case NAME:
			return new NamePatch();
		default:
			return null;
		}
	}
	
	private static void out(String s) {
		System.out.println(s);
	}
}
