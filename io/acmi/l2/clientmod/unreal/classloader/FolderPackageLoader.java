/*
 * Copyright (c) 2014 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.classloader;

import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.UnrealException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class FolderPackageLoader implements PackageLoader {
    private final File folder;
    private final Charset charset;

    private final Map<String, UnrealPackageReadOnly> uPackages = new HashMap<>();

    public FolderPackageLoader(File folder) {
        this.folder = folder;
        this.charset = Charset.forName(System.getProperty("unreal.charset", "EUC-KR"));
    }

    public FolderPackageLoader(String folder) {
        this(new File(folder));
    }

    @Override
    public UnrealPackageReadOnly apply(String name) throws UnrealException {
        if (!uPackages.containsKey(name)) {
            try (UnrealPackageFile up = new UnrealPackageFile(new File(folder, name + ".u"), true, charset)) {
                uPackages.put(name, up);
            } catch (IOException e) {
                throw new UnrealException(String.format("Couldn't load package %s.", name), e);
            }
        }
        return uPackages.get(name);
    }
}
