package m0nster.efpatcher;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.classloader.PackageLoader;

public class MultiPackageLoader implements PackageLoader {
	private final File[] folders;
    private final Charset charset;

    private final Map<String, UnrealPackageReadOnly> uPackages = new HashMap<>();

    public MultiPackageLoader(File... folders) {
        this.folders = folders;
        this.charset = Charset.forName(System.getProperty("unreal.charset", "EUC-KR"));
    }

    @Override
    public UnrealPackageReadOnly apply(String name) throws UnrealException {
        if (!uPackages.containsKey(name)) {
        	boolean suc = false;
        	for(File folder : folders) {
        		File f = new File(folder, name + ".u");
        		if(!f.exists())
        			continue;
	            try (UnrealPackageFile up = new UnrealPackageFile(f, true, charset)) {
	                uPackages.put(name, up);
	                suc = true;
	            } catch (IOException e) {
	                throw new UnrealException(String.format("Couldn't load package %s.", name), e);
	            }
        	}
        	if(!suc)
        		throw new UnrealException(String.format("Couldn't load package %s.", name));
        }
        return uPackages.get(name);
    }
}
