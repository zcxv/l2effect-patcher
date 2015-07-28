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
			clazz = Class.forName("ru.pointer.efpatcher.enums." + entry[0]);
		} catch (ClassNotFoundException e1) {
			out("Enum " + entry[0] + " not found");
			return;
		}
		
		Class<? extends Enum> eclazz = clazz.asSubclass(Enum.class);
		byte bValue = 0;
		for(Enum e : eclazz.getEnumConstants()) {
			if(e.name().equals(entry[1])) {
				bValue = (byte) e.ordinal();
				break;
			}
		}
		
		if(bValue < 1) {
			out("Value " + entry[1] + " in " + entry[0] + " not found");
			return;
		}
		
		property.putAt(0, bValue);
	}

}
