package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class CompressionUtilsextractZipFileWithPermissions_ZipFilegetEntriesFikaTest {

    @TempDir
    File tempDir;

    @Test
    public void testExtractZipFileWithPermissionsInvokesGetEntries() throws IOException {
        File zipFile = new File(tempDir, "test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }

        String targetPath = tempDir.getAbsolutePath();
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetPath);
    }
}
