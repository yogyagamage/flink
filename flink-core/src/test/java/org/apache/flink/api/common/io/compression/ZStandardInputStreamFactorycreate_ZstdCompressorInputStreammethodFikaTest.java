package org.apache.flink.api.common.io.compression;

import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZStandardInputStreamFactorycreate_ZstdCompressorInputStreammethodFikaTest {

    @Test
    public void testCreateMethodInvokesZstdCompressorInputStreamConstructor() throws IOException {
        ZStandardInputStreamFactory factory = new ZStandardInputStreamFactory();
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        ZstdCompressorInputStream result = factory.create(inputStream);
    }
}
