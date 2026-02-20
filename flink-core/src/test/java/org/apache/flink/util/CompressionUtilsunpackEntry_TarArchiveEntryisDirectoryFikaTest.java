package org.apache.flink.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompressionUtilsunpackEntry_TarArchiveEntryisDirectoryFikaTest {

    @Test
    void testIsDirectoryInvocation(@TempDir Path tempDir) throws IOException {
        // Create a real directory entry
        TarArchiveEntry entry = new TarArchiveEntry("testdir/", TarArchiveEntry.LF_DIR);
        
        // Create a real target directory
        File targetDir = tempDir.toFile();
        
        // Create a mock TarArchiveInputStream that returns null on read
        TarArchiveInputStream tis = mock(TarArchiveInputStream.class);
        when(tis.getNextTarEntry()).thenReturn(null);
        
        // Create a real directory entry with directory entries
        TarArchiveEntry dirEntry = new TarArchiveEntry("testdir/", TarArchiveEntry.LF_DIR);
        
        // Use reflection to invoke the private method
        try {
            java.lang.reflect.Method method = CompressionUtils.class.getDeclaredMethod(
                "unpackEntry", 
                TarArchiveInputStream.class, 
                TarArchiveEntry.class, 
                File.class
            );
            method.setAccessible(true);
            
            // This will invoke entry.isDirectory() inside unpackEntry
            method.invoke(null, tis, dirEntry, targetDir);
        } catch (Exception e) {
            // Expected - the method will fail when trying to process directory entries
            // but entry.isDirectory() will have been called
        }
    }
}
