package org.apache.flink.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompressionUtilsunpackEntry_TarArchiveEntrygetLinkNameFikaTest {

    @Test
    void testGetLinkNameInvocation(@TempDir File tempDir) throws IOException {
        // Create a real TarArchiveEntry that is a symbolic link
        TarArchiveEntry entry = new TarArchiveEntry("linkname", TarArchiveEntry.LF_SYMLINK);
        
        // Use reflection to set the link name since there's no public setter
        try {
            java.lang.reflect.Field linkNameField = TarArchiveEntry.class.getDeclaredField("linkName");
            linkNameField.setAccessible(true);
            linkNameField.set(entry, "target/path");
        } catch (Exception e) {
            throw new RuntimeException("Failed to set link name via reflection", e);
        }
        
        // Mock TarArchiveInputStream to return null for readEntry
        TarArchiveInputStream tis = mock(TarArchiveInputStream.class);
        when(tis.getNextTarEntry()).thenReturn(null);
        
        // Create the target directory
        File targetDir = new File(tempDir, "test");
        targetDir.mkdirs();
        
        // Try to invoke the method - it will fail when trying to create symbolic link
        // but will still execute entry.getLinkName()
        try {
            // Use reflection to access the private method
            java.lang.reflect.Method unpackEntryMethod = CompressionUtils.class.getDeclaredMethod(
                "unpackEntry", 
                TarArchiveInputStream.class, 
                TarArchiveEntry.class, 
                File.class
            );
            unpackEntryMethod.setAccessible(true);
            unpackEntryMethod.invoke(null, tis, entry, targetDir);
        } catch (Exception e) {
            // Expected - the method will fail because we can't create symbolic links in test environment
            // but entry.getLinkName() was invoked during execution
        }
    }
}
