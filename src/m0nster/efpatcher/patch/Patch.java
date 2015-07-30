package m0nster.efpatcher.patch;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.unreal.classloader.L2Property;

/**
 * @author PointerRage
 *
 */
public abstract class Patch {
	public abstract void patch(UnrealPackageFile upf, L2Property property, String value);
	
	
	
	protected void printf(String line, Object...args) {
		System.out.printf(line, args);
	}
	
	protected void out() {
		System.out.println();
	}
	
	protected void out(String s) {
		System.out.println(s);
	}
	
	protected String printData(byte[] data, int len) {
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

	protected String fillHex(int data, int digits) {
		String number = Integer.toHexString(data);

		for (int i = number.length(); i < digits; i++)
			number = "0" + number;

		return number;
	}
	
	protected String printData(byte[] raw) {
		return printData(raw, raw.length);
	}
}
