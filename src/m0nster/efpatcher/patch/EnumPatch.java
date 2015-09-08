package m0nster.efpatcher.patch;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.L2Property;
import acmi.l2.clientmod.unreal.classloader.UnrealClassLoader;
import acmi.l2.clientmod.unreal.core.ByteProperty;
import acmi.l2.clientmod.unreal.core.Enum;

/**
 * @author PointerRage
 */
public class EnumPatch extends Patch {
    private UnrealClassLoader classLoader;

    public EnumPatch(UnrealClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void patch(UnrealPackageFile upf, L2Property property, String value) {
        String enumValue = value.substring(value.lastIndexOf(".") + 1);

        UnrealPackageReadOnly.ExportEntry enumEntry = classLoader
                .getExportEntry(((ByteProperty) property.getTemplate()).getEnumType().getObjectFullName(),
                        e -> e.getObjectClass().getObjectFullName().equals("Core.Enum"))
                .orElseThrow(() -> new IllegalStateException("Enum " + property.getTemplate().getEntry().getObjectFullName() + " not found"));
        Enum uEnum = (Enum) classLoader.loadField(enumEntry);

        int bValue = -1;
        for (int i = 0; i < uEnum.getValues().size(); i++) {
            if (uEnum.getValues().get(i).equalsIgnoreCase(enumValue)) {
                bValue = i;
                break;
            }
        }

        if (bValue < 0) {
            throw new RuntimeException("Value " + enumValue + " in " + enumEntry.getObjectName().getName() + " not found");
        }

        property.putAt(0, bValue);
    }
}
