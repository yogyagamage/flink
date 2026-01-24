package org.apache.flink.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionUtilsextractZipFileWithPermissions_ZipArchiveEntrygetNameFikaTest {

    @Test
    public void testExtractZipFileWithPermissions(@TempDir Path tempDir) throws IOException {
        File zipFile = createValidZipFile(tempDir);
        File targetDir = tempDir.resolve("target").toFile();
        targetDir.mkdirs();
        
        CompressionUtils.extractZipFileWithPermissions(zipFile.getAbsolutePath(), targetDir.getAbsolutePath());
    }

    private File createValidZipFile(Path tempDir) throws IOException {
        File zipFile = tempDir.resolve("test.zip").toFile();
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("test content".getBytes());
            zos.closeEntry();
        }
        return zipFile;
    }
}
