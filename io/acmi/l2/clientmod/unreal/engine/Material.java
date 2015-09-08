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
package acmi.l2.clientmod.unreal.engine;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;
import acmi.l2.clientmod.unreal.core.Object;

import java.io.IOException;

public class Material extends Object {
    public Material(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        super(input, entry, propertiesUtil);

        readUnk(input, entry.getUnrealPackage().getVersion(), entry.getUnrealPackage().getLicensee());
    }

    private void readUnk(DataInput obj, int version, int licensee) throws IOException {
        if (licensee <= 10) {
            //???
        } else if (licensee <= 28) {
            //c0-ct0
            obj.readInt();
        } else if (licensee <= 32) {
            //???
        } else if (licensee <= 35) {
            //ct1-ct22
            obj.skip(1067);
            for (int i = 0; i < 16; i++)
                obj.readLine();
            obj.readLine();
            obj.readInt();
        } else if (licensee == 36) {
            //ct22
            obj.skip(1058);
            for (int i = 0; i < 16; i++)
                obj.readLine();
            obj.readLine();
            obj.readInt();
        } else if (licensee <= 39) {
            //Epeisodion
            if (version == 129) {
                obj.skip(92);
                int stringCount = obj.readCompactInt();
                for (int i = 0; i < stringCount; i++) {
                    obj.readLine();
                    int addStringCount = obj.readUnsignedByte();
                    for (int j = 0; j < addStringCount; j++)
                        obj.readLine();
                }
                obj.readLine();
                obj.readInt();
                return;
            }

            //ct23-Lindvior
            obj.skip(36);
            int stringCount = obj.readCompactInt();
            for (int i = 0; i < stringCount; i++) {
                obj.readLine();
                int addStringCount = obj.readUnsignedByte();
                for (int j = 0; j < addStringCount; j++)
                    obj.readLine();
            }
            obj.readLine();
            obj.readInt();
        } else {
            //Ertheia+
            obj.skip(92);
            int stringCount = obj.readCompactInt();
            for (int i = 0; i < stringCount; i++) {
                obj.readLine();
                int addStringCount = obj.readUnsignedByte();
                for (int j = 0; j < addStringCount; j++)
                    obj.readLine();
            }
            obj.readLine();
            obj.readInt();
        }
    }
}
