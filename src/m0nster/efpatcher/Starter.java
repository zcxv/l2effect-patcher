package m0nster.efpatcher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Consumer;

import m0nster.efpatcher.patch.EnumPatch;
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
		String replace = "LineageEffect.su_sleep_ta";
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
				out(printData(uobj.getEntry().getObjectRawDataExternally()));
				
				List<L2Property> properties = uobj.getProperties();
				for(L2Property prop : properties) {
					out("\t" + prop.toString());
					if(isReferenced(prop.getType())) {
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
			AsIsObject uobj = upf.getExportTable().stream().
					filter(entry -> entry.getObjectInnerFullName().equals(objectName)).findAny().
					map(oFactory).map(raw -> (AsIsObject)raw).orElse(null);
				
			if(uobj == null) {
				out("Object not found");
				return;
			}
			out("-----------");
			
			out(uobj.getEntry().getObjectInnerFullName());
			out(printData(uobj.getEntry().getObjectRawDataExternally()));
			
			List<L2Property> properties = uobj.getProperties();
			for(L2Property prop : properties) {
				if(prop.getName().equals(reqField)) {
					out("\t" + prop.toString());
					Patch patch = createPatch(prop);
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
				out(printData(baos.toByteArray()));
				((ExportEntry)uobj.getEntry()).setObjectRawData(baos.toByteArray(), true);
			}
			
			upf.reload();
		}
	}
	
	private static Patch createPatch(L2Property property) {
		if(property.getName().equals("AttachOn")) {
			return new EnumPatch();
		}
		
		switch (property.getType()) {
		case OBJECT:
			return new ObjectPatch();
		default:
			break;
		}
		
		return null;
	}
	
	private static boolean isReferenced(Type type) {
		switch (type) {
		case NONE:
		case BYTE:
		case INT:
		case BOOL:
		case FLOAT:
		//case STRUCT:
		//case VECTOR:
		//case ROTATOR:
			return false;
		default:
			return true;
		}
	}
	
	private static void printf(String line, Object...args) {
		System.out.printf(line, args);
	}
	
	private static void out() {
		System.out.println();
	}
	
	private static void out(String s) {
		System.out.println(s);
	}
	
	private static String printData(byte[] data, int len) {
		StringBuffer result = new StringBuffer();

		int counter = 0;

		for (int i = 0; i < len; i++) {
			if (counter % 16 == 0)
				result.append(fillHex(i, 4) + ": ");

			result.append(fillHex(data[i] & 0xff, 2) + " ");
			counter++;
			if (counter == 16) {
				result.append("\n");
				counter = 0;
			}
		}

		return result.toString();
	}

	private static String fillHex(int data, int digits) {
		String number = Integer.toHexString(data);

		for (int i = number.length(); i < digits; i++)
			number = "0" + number;

		return number;
	}
	
	private static String printData(byte[] raw) {
		return printData(raw, raw.length);
	}
}
