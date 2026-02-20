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

import static org.apache.flink.util.CompressionUtils.extractZipFileWithPermissions;

public class CompressionUtilsextractZipFileWithPermissions_ZipFilegetEntriesFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissionsInvokesGetEntries() throws IOException {
        // Create a minimal zip file
        Path zipPath = tempDir.resolve("test.zip");
        Path extractDir = tempDir.resolve("extract");
        Files.createDirectories(extractDir);

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        // This will invoke ZipFile.getEntries() inside extractZipFileWithPermissions
        extractZipFileWithPermissions(zipPath.toString(), extractDir.toString());
    }
}
