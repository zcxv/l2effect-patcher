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
package acmi.l2.clientmod.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static acmi.l2.clientmod.util.CollectionsMethods.indexIf;

public interface UnrealPackageReadOnly {
    Charset getCharset();

    int getVersion();

    int getLicensee();

    int getFlags();

    List<? extends NameEntry> getNameTable();

    List<? extends ExportEntry> getExportTable();

    List<? extends ImportEntry> getImportTable();

    default int nameReference(String name) {
        return indexIf(getNameTable(), e -> e.getName().equalsIgnoreCase(name));
    }

    default String nameReference(int ref) {
        return getNameTable().get(ref).getName();
    }

    default Entry objectReference(int ref) {
        if (ref > 0)
            return getExportTable().get(ref - 1);
        else if (ref < 0)
            return getImportTable().get(-ref - 1);
        else
            return null;
    }

    public interface NameEntry {
        String getName();

        int getFlags();
    }

    public interface Entry {
        UnrealPackageReadOnly getUnrealPackage();

        int getObjectReference();

        Entry getObjectPackage();

        NameEntry getObjectName();

        default String getObjectFullName() {
            return getObjectInnerFullName();
        }

        String getObjectInnerFullName();
    }

    public interface ImportEntry extends Entry {
        UnrealPackageReadOnly getUnrealPackage();

        NameEntry getClassPackage();

        NameEntry getClassName();
    }

    public interface ExportEntry extends Entry {
        Entry getObjectClass();

        Entry getObjectSuperClass();

        int getObjectFlags();

        int getSize();

        int getOffset();

        byte[] getObjectRawDataExternally() throws IOException;
    }

    public enum ObjectFlag {
        /**
         * Object is transactional.
         */
        Transactional,
        /**
         * Object is not reachable on the object graph.
         */
        Unreachable,
        /**
         * Object is visible outside its package.
         */
        Public,
        /**
         * Temporary import tag in load/save.
         */
        TagImp,
        /**
         * Temporary export tag in load/save.
         */
        TagExp,
        /**
         * Modified relative to source files.
         */
        SourceModified,
        /**
         * Check during garbage collection.
         */
        TagGarbage,
        Flag7,
        Flag8,
        /**
         * During load, indicates object needs loading.
         */
        NeedLoad,
        /**
         * A hardcoded name which should be syntaxhighlighted.
         */
        HighlightedName,
        /**
         * In a singular function.
         */
        InSingularFunc,
        /**
         * Suppressed log name.
         */
        Suppress,
        /**
         * Within an EndState call.
         */
        InEndState,
        /**
         * Don't save object.
         */
        Transient,
        /**
         * Data is being preloaded from file.
         */
        PreLoading,
        /**
         * In-file load for client.
         */
        LoadForClient,
        /**
         * In-file load for client.
         */
        LoadForServer,
        /**
         * In-file load for client.
         */
        LoadForEdit,
        /**
         * Keep object around for editing even if unreferenced.
         */
        Standalone,
        /**
         * Don't load this object for the game client.
         */
        NotForClient,
        /**
         * Don't load this object for the game server.
         */
        NotForServer,
        /**
         * Don't load this object for the editor.
         */
        NotForEdit,
        /**
         * Object Destroy has already been called.
         */
        Destroyed,
        /**
         * Object needs to be postloaded.
         */
        NeedPostLoad,
        /**
         * Has execution stack.
         */
        HasStack,
        /**
         * Native (UClass only).
         */
        Native,
        /**
         * Marked (for debugging).
         */
        Marked,
        /**
         * ShutdownAfterError called.
         */
        ErrorShutdown,
        /**
         * For debugging Serialize calls.
         */
        DebugPostLoad,
        /**
         * For debugging Serialize calls.
         */
        DebugSerialize,
        /**
         * For debugging Destroy calls.
         */
        DebugDestroy;

        private int mask;

        ObjectFlag() {
            this.mask = 1 << ordinal();
        }

        public int getMask() {
            return mask;
        }

        @Override
        public String toString() {
            return "RF_" + name();
        }

        public static Collection<ObjectFlag> getFlags(int flags) {
            return Arrays.stream(values())
                    .filter(e -> (e.getMask() & flags) != 0)
                    .collect(Collectors.toList());
        }

        public static int getFlags(ObjectFlag... flags) {
            int v = 0;
            for (ObjectFlag flag : flags)
                v |= flag.getMask();
            return v;
        }
    }

    public static final int PACKAGE_FLAGS = ObjectFlag.getFlags(
            ObjectFlag.Public,
            ObjectFlag.LoadForClient,
            ObjectFlag.LoadForServer,
            ObjectFlag.LoadForEdit);

    public enum PackageFlag {
        /**
         * Allow downloading package
         */
        AllowDownload(0),
        /**
         * Purely optional for clients
         */
        ClientOptional(1),
        /**
         * Only needed on the server side
         */
        ServerSideOnly(2),
        /**
         * Loaded from linker with broken import links
         */
        BrokenLinks(3),
        /**
         * Not trusted
         */
        Unsecure(4),
        /**
         * Client needs to download this package
         */
        Need(15);

        private int mask;

        PackageFlag(int bit) {
            this.mask = 1 << bit;
        }

        public int getMask() {
            return mask;
        }

        @Override
        public String toString() {
            return "PKG_" + name();
        }

        public static Collection<PackageFlag> getFlags(int flags) {
            return Arrays.stream(values())
                    .filter(e -> (e.getMask() & flags) != 0)
                    .collect(Collectors.toList());
        }

        public static int getFlags(PackageFlag... flags) {
            int v = 0;
            for (PackageFlag flag : flags)
                v |= flag.getMask();
            return v;
        }
    }
}
