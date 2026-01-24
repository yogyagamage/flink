package org.apache.flink.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipFilegetInputStreamFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a temporary zip file with at least one entry
        Path zipFilePath = tempDir.resolve("test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        // Create target directory
        Path targetPath = tempDir.resolve("target");
        Files.createDirectories(targetPath);

        // Call the entry point method
        CompressionUtils.extractZipFileWithPermissions(zipFilePath.toString(), targetPath.toString());
    }
}
