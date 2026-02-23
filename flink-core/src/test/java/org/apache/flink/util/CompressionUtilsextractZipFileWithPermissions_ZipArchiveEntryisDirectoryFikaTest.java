package org.apache.flink.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntryisDirectoryFikaTest {

    @Test
    public void testExtractZipFileWithPermissionsInvokesIsDirectory(@TempDir Path tempDir) throws IOException {
        // Create a temporary zip file with at least one directory entry
        File zipFile = new File(tempDir.toFile(), "test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            // Add a directory entry
            ZipArchiveEntry dirEntry = new ZipArchiveEntry("testdir/");
            zos.putNextEntry(dirEntry);
            zos.closeEntry();
            
            // Add a file entry to ensure the loop continues
            ZipArchiveEntry fileEntry = new ZipArchiveEntry("testdir/file.txt");
            zos.putNextEntry(fileEntry);
            zos.write("content".getBytes());
            zos.closeEntry();
        }
        
        // Create target directory
        File targetDir = new File(tempDir.toFile(), "target");
        targetDir.mkdirs();
        
        // Call the entry point method - this will traverse the path and invoke ZipArchiveEntry.isDirectory()
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }
}
