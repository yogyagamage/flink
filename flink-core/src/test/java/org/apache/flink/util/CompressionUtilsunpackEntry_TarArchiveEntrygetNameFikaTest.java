package org.apache.flink.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class CompressionUtilsunpackEntry_TarArchiveEntrygetNameFikaTest {

    @Test
    void test(@TempDir File targetDir) throws Exception {
        TarArchiveInputStream tis = new TarArchiveInputStream(new ByteArrayInputStream(new byte[0]));
        TarArchiveEntry entry = new TarArchiveEntry("file.txt");

        Method method = CompressionUtils.class.getDeclaredMethod(
                "unpackEntry",
                TarArchiveInputStream.class,
                TarArchiveEntry.class,
                File.class
        );
        method.setAccessible(true);

        try {
            method.invoke(null, tis, entry, targetDir);
        } catch (InvocationTargetException ignored) {
        }
    }
}
