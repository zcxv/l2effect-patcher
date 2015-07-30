package m0nster.efpatcher.patch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import m0nster.efpatcher.Util;
import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.unreal.classloader.L2Property;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil.Type;

/**
 * @author PointerRage
 *
 */
public class NamePatch extends Patch {

	@Override
	public void patch(UnrealPackageFile upf, L2Property property, String value) {
		int ref = (int)property.getAt(0);
		
		if(!Util.isActiveReference(getObjects(), Type.NAME, ref, property)) { //exists only one reference in current property/field
			out("Update value on reference from " + upf.nameReference(ref) + " to " + value);
			try {
				upf.updateNameEntry(ref, value, UnrealPackageFile.PACKAGE_FLAGS);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to update name entry");
			}
			return;
		}
		
		Map<String, Integer> names = new HashMap<>();
		names.put(value, UnrealPackageFile.PACKAGE_FLAGS);
		out("Adding new name entry...");
		try {
			upf.addNameEntries(names);
		} catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add new name entry");
		}
		
		int newRef = upf.nameReference(value);
		if(newRef == -1) {
			throw new RuntimeException("New reference not found");
		}
		
		out("Change " + ref + " to " + newRef);
		property.putAt(0, newRef);
	}

}
