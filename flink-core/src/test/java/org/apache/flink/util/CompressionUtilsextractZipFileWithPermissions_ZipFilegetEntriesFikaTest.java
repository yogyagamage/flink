package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CompressionUtilsextractZipFileWithPermissions_ZipFilegetEntriesFikaTest {

    @Test
    public void testExtractZipFileWithPermissionsInvokesGetEntries(@TempDir Path tempDir) throws IOException {
        // Create a minimal valid zip file
        File zipFile = new File(tempDir.toFile(), "test.zip");
        File targetDir = new File(tempDir.toFile(), "target");
        
        // Create a simple zip file with one entry
        java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(
            new java.io.FileOutputStream(zipFile));
        java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry("test.txt");
        zos.putNextEntry(entry);
        zos.write("test content".getBytes());
        zos.closeEntry();
        zos.close();
        
        // Invoke the method - this will call ZipFile.getEntries()
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }
}
