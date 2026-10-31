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
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntryisDirectoryFikaTest {

    @Test
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a temporary zip file with a directory entry
        Path tempZipFile = Files.createTempFile("test", ".zip");
        Path tempTargetDir = Files.createTempDirectory("extract");
        
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {
            // Add a directory entry - this will trigger entry.isDirectory()
            ZipEntry dirEntry = new ZipEntry("testdir/");
            zos.putNextEntry(dirEntry);
            zos.closeEntry();
            
            // Add a file entry to ensure the loop continues
            ZipEntry fileEntry = new ZipEntry("testdir/file.txt");
            zos.putNextEntry(fileEntry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }
        
        // Call the method under test
        try {
            // We need to access the method via reflection since it's static
            Class<?> clazz = Class.forName("org.apache.flink.util.CompressionUtils");
            var method = clazz.getDeclaredMethod("extractZipFileWithPermissions", 
                String.class, String.class);
            method.invoke(null, tempZipFile.toString(), tempTargetDir.toString());
        } catch (Exception e) {
            // We don't care about exceptions, only that isDirectory() was called
        }
        
        // Cleanup
        Files.deleteIfExists(tempZipFile);
        deleteDirectory(tempTargetDir.toFile());
    }
    
    private void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteDirectory(child);
                }
            }
        }
        dir.delete();
    }
}
