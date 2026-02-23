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

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntryisUnixSymlinkFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testExtractZipFileWithPermissionsInvokesIsUnixSymlink() throws IOException {
        Path zipFilePath = tempDir.resolve("test.zip");
        Path targetPath = tempDir.resolve("target");

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath.toFile()))) {
            ZipEntry symlinkEntry = new ZipEntry("symlink.txt");
            zos.putNextEntry(symlinkEntry);
            zos.write("target.txt".getBytes());
            zos.closeEntry();
        }

        CompressionUtils.extractZipFileWithPermissions(zipFilePath.toString(), targetPath.toString());
    }
}
