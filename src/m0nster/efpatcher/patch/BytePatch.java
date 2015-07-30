package m0nster.efpatcher.patch;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.unreal.classloader.L2Property;

/**
 * @author PointerRage
 *
 */
public class BytePatch extends Patch {

	@Override
	public void patch(UnrealPackageFile upf, L2Property property, String value) {
		int iValue;
		try {
			iValue = Integer.parseInt(value);
		} catch(NumberFormatException e) {
			throw new RuntimeException("Failed transform value to number");
		}
		
		property.putAt(0, iValue);
	}

}
