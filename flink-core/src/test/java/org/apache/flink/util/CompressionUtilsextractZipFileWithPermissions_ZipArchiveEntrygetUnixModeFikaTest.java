package org.apache.flink.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntrygetUnixModeFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissionsInvokesGetUnixMode() throws IOException {
        // Create a temporary zip file with at least one entry
        File zipFile = new File(tempDir.toFile(), "test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        // Create target directory
        File targetDir = new File(tempDir.toFile(), "target");
        targetDir.mkdirs();

        // Execute the entry point method
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }
}
