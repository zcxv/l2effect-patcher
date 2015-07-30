package m0nster.efpatcher.patch;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.unreal.classloader.L2Property;

/**
 * @author PointerRage
 *
 */
public class EnumPatch extends Patch {
	
	@Override
	public void patch(UnrealPackageFile upf, L2Property property, String value) {
		String[] entry = value.split("\\.");
		Class<?> clazz;
		try {
			clazz = Class.forName("m0nster.efpatcher.enums." + entry[0]);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Enum " + entry[0] + " not found");
		}
		
		Class<? extends Enum> eclazz = clazz.asSubclass(Enum.class);
		int bValue = -1;
		for(Enum e : eclazz.getEnumConstants()) {
			if(e.name().equals(entry[1])) {
				bValue = e.ordinal();
				break;
			}
		}
		
		if(bValue < 0) {
			throw new RuntimeException("Value " + entry[1] + " in " + entry[0] + " not found");
		}
		
		property.putAt(0, bValue);
		
	}

}
