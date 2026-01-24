package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntryisUnixSymlinkFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissions() throws IOException {
        // Create a zip file containing a symlink entry
        File zipFile = new File(tempDir.toFile(), "test.zip");
        
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            // Create a symlink entry using ZipArchiveEntry
            ZipArchiveEntry symlinkEntry = new ZipArchiveEntry("symlink.txt");
            symlinkEntry.setUnixMode(0xA000); // S_IFLNK for symlink
            zos.putNextEntry(symlinkEntry);
            zos.write("target.txt".getBytes());
            zos.closeEntry();
            
            // Create a regular file entry
            ZipEntry regularEntry = new ZipEntry("regular.txt");
            zos.putNextEntry(regularEntry);
            zos.write("content".getBytes());
            zos.closeEntry();
        }

        // Create target directory
        File targetDir = new File(tempDir.toFile(), "target");
        targetDir.mkdirs();

        // Call the entry point method
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }
}
