package org.apache.flink.util;

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
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a temporary zip file with at least one entry
        Path zipFilePath = tempDir.resolve("test.zip");
        Path extractDir = tempDir.resolve("extract");
        
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile()))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }
        
        // Create extraction directory
        extractDir.toFile().mkdirs();
        
        // Execute the entry point method
        CompressionUtils.extractZipFileWithPermissions(zipFilePath.toString(), extractDir.toString());
    }
}
