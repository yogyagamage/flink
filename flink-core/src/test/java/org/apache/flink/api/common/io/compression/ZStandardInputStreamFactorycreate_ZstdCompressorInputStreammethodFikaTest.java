package org.apache.flink.api.common.io.compression;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;

class ZStandardInputStreamFactorycreate_ZstdCompressorInputStreammethodFikaTest {

    @Test
    void testCreateMethodCallsZstdCompressorInputStreamConstructor() throws IOException {
        ZStandardInputStreamFactory factory = new ZStandardInputStreamFactory();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        
        try (ZstdCompressorInputStream result = factory.create(inputStream)) {
            // No assertions - just executing the method chain
        }
    }
}
