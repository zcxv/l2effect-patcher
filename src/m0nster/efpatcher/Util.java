package m0nster.efpatcher;

import java.util.List;

import acmi.l2.clientmod.unreal.classloader.L2Property;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil.Type;
import acmi.l2.clientmod.unreal.objectfactory.AsIsObject;

/**
 * @author PointerRage
 *
 */
public class Util {
	private Util() {}
	
	public static boolean isActiveReference(List<AsIsObject> objects, Type type, int ref, L2Property except) {
		if(!isReferenced(type))
			return true;
		
		return objects.stream()
			.flatMap(export -> export.getProperties().stream())
			.filter(prop -> prop.getType() == type)
			.filter(prop -> prop != except)
			.anyMatch(prop -> (int)prop.getAt(0) == ref);
	}
	
	public static AsIsObject findExport(List<AsIsObject> objects, String name) {
		return objects.stream()
				.filter(e -> e.getEntry().getObjectInnerFullName().equals(name))
				.findAny()
				.orElse(null);
	}
	
	public static boolean isReferenced(Type type) {
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
	
	public static String printData(byte[] data, int len) {
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

	public static String fillHex(int data, int digits) {
		String number = Integer.toHexString(data);

		for (int i = number.length(); i < digits; i++)
			number = "0" + number;

		return number;
	}
	
	public static String printData(byte[] raw) {
		return printData(raw, raw.length);
	}
}
