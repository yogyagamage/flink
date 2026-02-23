package org.apache.flink.api.common.io.compression;

import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class ZStandardInputStreamFactorycreate_ZstdCompressorInputStreammethodFikaTest {

    @Test
    void testCreateMethodInvokesZstdCompressorInputStreamConstructor() throws IOException {
        ZStandardInputStreamFactory factory = new ZStandardInputStreamFactory();
        InputStream testInputStream = new ByteArrayInputStream(new byte[0]);
        
        factory.create(testInputStream);
    }
}
