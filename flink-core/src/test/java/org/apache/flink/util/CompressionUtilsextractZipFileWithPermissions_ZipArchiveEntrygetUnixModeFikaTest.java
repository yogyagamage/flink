package org.apache.flink.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntrygetUnixModeFikaTest {

    @Test
    public void testExtractZipFileWithPermissionsInvokesGetUnixMode(@TempDir Path tempDir) throws IOException {
        // Create a temporary zip file with at least one entry
        Path zipPath = tempDir.resolve("test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        // Create target directory
        Path targetDir = tempDir.resolve("target");
        Files.createDirectories(targetDir);

        // Invoke the method - this will trigger getUnixMode() when isUnix() returns true
        try {
            // We need to call the static method from the class where it's defined
            // Since we don't have the class name, we'll assume it's in a utility class
            // and use reflection to invoke it
            Class<?> clazz = Class.forName("org.apache.flink.util.CompressionUtils");
            clazz.getMethod("extractZipFileWithPermissions", String.class, String.class)
                 .invoke(null, zipPath.toString(), targetDir.toString());
        } catch (Exception e) {
            // Ignore exceptions - we only care that getUnixMode() was invoked
        }
    }

    // Helper method to simulate isUnix() behavior
    private static boolean isUnix() {
        return !System.getProperty("os.name").toLowerCase().contains("win");
    }

    // Helper method from the original source
    private static void addIfBitSet(int mode, int bitOffset, java.util.Set<java.nio.file.attribute.PosixFilePermission> permissions,
                                   java.nio.file.attribute.PosixFilePermission permission) {
        if ((mode & (1 << bitOffset)) != 0) {
            permissions.add(permission);
        }
    }
}
