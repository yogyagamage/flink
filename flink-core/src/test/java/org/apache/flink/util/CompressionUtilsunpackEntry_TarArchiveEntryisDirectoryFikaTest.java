package org.apache.flink.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CompressionUtilsunpackEntry_TarArchiveEntryisDirectoryFikaTest {

    @TempDir
    private File targetDir;

    @Test
    void testInvokeTarArchiveEntryIsDirectory() throws Exception {
        TarArchiveEntry entry = new TarArchiveEntry("dir/", TarConstants.LF_DIR);
        entry.setMode(040755);

        Method method = CompressionUtils.class.getDeclaredMethod(
                "unpackEntry",
                TarArchiveInputStream.class,
                TarArchiveEntry.class,
                File.class);
        method.setAccessible(true);

        try (TarArchiveInputStream tis = new TarArchiveInputStream(new ByteArrayInputStream(new byte[0]))) {
            method.invoke(null, tis, entry, targetDir);
        } catch (InvocationTargetException ignored) {
        }
    }
}
