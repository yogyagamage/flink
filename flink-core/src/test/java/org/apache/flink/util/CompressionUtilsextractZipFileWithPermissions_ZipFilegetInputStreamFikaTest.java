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

public class CompressionUtilsextractZipFileWithPermissions_ZipFilegetInputStreamFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a temporary zip file with at least one entry
        Path zipFilePath = tempDir.resolve("test.zip");
        createTestZipFile(zipFilePath.toFile());
        
        // Create target directory
        Path targetPath = tempDir.resolve("target");
        Files.createDirectories(targetPath);
        
        // This will trigger the call chain: extractZipFileWithPermissions -> ZipFile.getInputStream
        CompressionUtils.extractZipFileWithPermissions(zipFilePath.toString(), targetPath.toString());
    }

    private void createTestZipFile(File zipFile) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            // Add a regular file entry
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
            
            // Add a directory entry
            ZipEntry dirEntry = new ZipEntry("subdir/");
            zos.putNextEntry(dirEntry);
            zos.closeEntry();
        }
    }
}
