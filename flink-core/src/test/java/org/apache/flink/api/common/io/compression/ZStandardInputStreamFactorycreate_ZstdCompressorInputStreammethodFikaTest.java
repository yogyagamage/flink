package org.apache.flink.api.common.io.compression;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ZStandardInputStreamFactorycreate_ZstdCompressorInputStreammethodFikaTest {

    @Test
    public void testCreateMethodCallsZstdCompressorInputStreamConstructor() throws IOException {
        ZStandardInputStreamFactory factory = new ZStandardInputStreamFactory();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        
        try (org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream result = 
                factory.create(inputStream)) {
            // No assertions - just ensuring the constructor is called
        }
    }
}
