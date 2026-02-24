package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipFilemethodFikaTest {

    @TempDir
    File tempDir;

    @Test
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a minimal valid zip file
        File zipFile = new File(tempDir, "test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        // Create target directory
        File targetDir = new File(tempDir, "target");
        targetDir.mkdirs();

        // This will invoke the chain: extractZipFileWithPermissions -> new ZipFile(String)
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }
}
