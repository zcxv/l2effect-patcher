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
package acmi.l2.clientmod.utxconv;

import acmi.l2.clientmod.io.RandomAccessFile;
import acmi.l2.clientmod.io.UnrealPackageFile;
import acmi.l2.clientmod.unreal.classloader.FolderPackageLoader;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;
import acmi.l2.clientmod.unreal.classloader.UnrealClassLoader;
import acmi.l2.clientmod.unreal.core.Package;
import acmi.l2.clientmod.unreal.engine.Font;
import acmi.l2.clientmod.unreal.engine.Material;
import acmi.l2.clientmod.unreal.engine.Palette;
import acmi.l2.clientmod.unreal.objectfactory.ObjectFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static acmi.l2.clientmod.io.ByteUtil.uuidToBytes;

public class ConvertTool {
    private static final int NEW_PACKAGE_VERSION = 0x00000076;

    public static void save(UnrealPackageFile up, File savePath, UnrealClassLoader classLoader) throws IOException {
        save(up, savePath, System.out, classLoader);
    }

    public static void save(UnrealPackageFile up, File savePath, PrintStream log, UnrealClassLoader classLoader) throws IOException {
        ObjectFactory objectFactory = new ObjectFactory(classLoader);
        PropertiesUtil propertiesUtil = classLoader.getPropertiesUtil();

        if (log == null)
            log = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                }
            });

        try (RandomAccessFile dest = new RandomAccessFile(savePath, false, Charset.forName("ascii"))) {
            dest.setLength(0);

            dest.writeInt(UnrealPackageFile.UNREAL_PACKAGE_MAGIC);
            dest.writeInt(NEW_PACKAGE_VERSION);
            dest.writeInt(up.getFlags());
            dest.writeInt(up.getNameTable().size());
            dest.writeInt(0);
            dest.writeInt(up.getExportTable().size());
            dest.writeInt(0);
            dest.writeInt(up.getImportTable().size());
            dest.writeInt(0);
            dest.write(uuidToBytes(up.getUUID()));
            dest.writeInt(up.getGenerations().size());
            for (UnrealPackageFile.Generation generation : up.getGenerations()) {
                dest.writeInt(generation.getExportCount());
                dest.writeInt(generation.getNameCount());
            }

            int nameOffset = dest.getPosition();
            dest.setPosition(16);
            dest.writeInt(nameOffset);
            dest.setPosition(nameOffset);
            for (int i = 0; i < up.getNameTable().size(); i++) {
                UnrealPackageFile.NameEntry nameEntry = up.getNameTable().get(i);
                if (!dest.getCharset().newEncoder().canEncode(nameEntry.getName()))
                    log.println("UTF->ASCII: " + nameEntry.getName());
                dest.writeBytes(nameEntry.getName());
                dest.writeInt(nameEntry.getFlags());
            }

            int[] exportSizes = new int[up.getExportTable().size()];
            int[] exportOffsets = new int[up.getExportTable().size()];
            boolean[] deleted = new boolean[up.getExportTable().size()];
            for (int i = 0; i < up.getExportTable().size(); i++) {
                exportOffsets[i] = dest.getPosition();
                UnrealPackageFile.ExportEntry exportEntry = up.getExportTable().get(i);
                acmi.l2.clientmod.unreal.core.Object object = objectFactory.apply(exportEntry);
                if (!(object instanceof Package) &&
                        !(object instanceof Material) &&
                        !(object instanceof Palette) &&
                        !(object instanceof Font)) {
                    object = new Package();
                    deleted[i] = true;
                }
                object.writeTo(dest, propertiesUtil);
                exportSizes[i] = dest.getPosition() - exportOffsets[i];
            }

            int importOffset = dest.getPosition();
            dest.setPosition(32);
            dest.writeInt(importOffset);
            dest.setPosition(importOffset);
            for (UnrealPackageFile.ImportEntry importEntry : up.getImportTable()) {
                dest.writeCompactInt(up.nameReference(importEntry.getClassPackage().getName()));
                dest.writeCompactInt(up.nameReference(importEntry.getClassName().getName()));
                dest.writeInt(importEntry.getObjectPackage() != null ? importEntry.getObjectPackage().getObjectReference() : 0);
                dest.writeCompactInt(up.nameReference(importEntry.getObjectName().getName()));
            }

            int exportOffset = dest.getPosition();
            dest.setPosition(24);
            dest.writeInt(exportOffset);
            dest.setPosition(exportOffset);
            for (int i = 0; i < up.getExportTable().size(); i++) {
                UnrealPackageFile.ExportEntry exportEntry = up.getExportTable().get(i);

                String objClass = exportEntry.getObjectClass().toString();
                if (deleted[i]) {
                    objClass = "Core.Package";
                    log.println("REMOVED: " + exportEntry.toString() + "[" + exportEntry.getObjectClass().getObjectFullName() + "]");
                }
                dest.writeCompactInt(up.objectReference(objClass));
                dest.writeCompactInt(exportEntry.getObjectSuperClass() != null ? exportEntry.getObjectSuperClass().getObjectReference() : 0);
                dest.writeInt(exportEntry.getObjectPackage() != null ? exportEntry.getObjectPackage().getObjectReference() : 0);
                dest.writeCompactInt(up.nameReference(exportEntry.getObjectName().getName()));
                dest.writeInt(exportEntry.getObjectFlags());
                dest.writeCompactInt(exportSizes[i]);
                dest.writeCompactInt(exportOffsets[i]);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("USAGE: " + ConvertTool.class.getSimpleName() + " l2_system l2_utx [ued_utx]");
            System.out.println("\tl2_system  - L2 system folder with .u packages");
            System.out.println("\tl2_utx  - input");
            System.out.println("\tued_utx - output");
            System.exit(0);
        }

        try (UnrealPackageFile up = new UnrealPackageFile(args[1], true)) {
            save(up, new File(args[2]), new UnrealClassLoader(new FolderPackageLoader(args[0])));
        } catch (IOException e) {
            System.err.print(e.getClass());
            if (e.getMessage() != null)
                System.err.print(": " + e.getMessage());
            System.err.println();
        }
    }
}
