package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntryisDirectoryFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissionsInvokesIsDirectory() throws IOException {
        // Create a zip file with at least one directory entry
        Path zipFilePath = tempDir.resolve("test.zip");
        Path extractDir = tempDir.resolve("extract");
        
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile()))) {
            // Add a directory entry (required to invoke isDirectory())
            ZipEntry dirEntry = new ZipEntry("testdir/");
            zos.putNextEntry(dirEntry);
            zos.closeEntry();
            
            // Add a file entry to ensure the loop continues
            ZipEntry fileEntry = new ZipEntry("testdir/file.txt");
            zos.putNextEntry(fileEntry);
            zos.write("content".getBytes());
            zos.closeEntry();
        }
        
        // Execute the entry point method
        CompressionUtils.extractZipFileWithPermissions(zipFilePath.toString(), extractDir.toString());
    }
}
