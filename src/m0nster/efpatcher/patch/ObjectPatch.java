package m0nster.efpatcher.patch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.io.UnrealPackageFile.Entry;
import acmi.l2.clientmod.io.UnrealPackageFile.ImportEntry;
import acmi.l2.clientmod.unreal.classloader.L2Property;

/**
 * @author PointerRage
 *
 */
public class ObjectPatch extends Patch {
	@Override
	public void patch(UnrealPackageFile upf, L2Property property, String value) {
		ImportEntry importEntry = upf.getImportTable().stream()
				.filter(entry -> entry.getObjectInnerFullName().equals(value))
				.findAny()
				.orElse(null);
		
		if(importEntry == null) {
			out("Add new import entry...");
			Map<String, String> imports = new HashMap<>();
			imports.put("Core.Class", value);
			try {
				upf.addImportEntries(imports, false);
			} catch(IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to add new import entry");
			}
			
			patch(upf, property, value);
			return;
		}
		
		out(importEntry.getObjectInnerFullName());
		
		int offset = (int)property.getAt(0);
		Entry ref = upf.objectReference(offset);
		out(offset + "=" + ref.toString());
		out();
		int reference = importEntry.getObjectReference();
		printf("Patching %d to %d ... ", offset, reference);
		property.putAt(0, reference);
	}
}
