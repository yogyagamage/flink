package org.apache.flink.orc.writer;

import org.apache.flink.core.fs.FSDataOutputStream;
import org.apache.orc.CompressionKind;
import org.apache.orc.OrcFile;
import org.apache.orc.impl.HadoopShims;
import org.apache.orc.impl.OrcCodecPool;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhysicalWriterImplclose_OrcCodecPoolreturnCodecFikaTest {

    @Test
    void testClose() throws IOException {
        // Create mock dependencies
        FSDataOutputStream mockOutputStream = mock(FSDataOutputStream.class);
        OrcFile.WriterOptions mockOptions = mock(OrcFile.WriterOptions.class);
        HadoopShims mockShims = mock(HadoopShims.class);
        
        // Configure mock options to provide necessary values for constructor
        when(mockOptions.isEnforceBufferSize()).thenReturn(false);
        when(mockOptions.getBufferSize()).thenReturn(256 * 1024);
        when(mockOptions.getStripeSize()).thenReturn(64L * 1024 * 1024);
        when(mockOptions.getSchema()).thenReturn(org.apache.orc.TypeDescription.createStruct());
        when(mockOptions.getBlockSize()).thenReturn(256L * 1024 * 1024);
        when(mockOptions.getPaddingTolerance()).thenReturn(0.0);
        when(mockOptions.getCompress()).thenReturn(CompressionKind.NONE);
        when(mockOptions.getHadoopShims()).thenReturn(mockShims);
        when(mockOptions.getBlockPadding()).thenReturn(false);
        when(mockOptions.getWriteVariableLengthBlocks()).thenReturn(false);
        
        // Create instance using constructor
        PhysicalWriterImpl writer = new PhysicalWriterImpl(mockOutputStream, mockOptions);
        
        // Call the entry point method - this should trigger OrcCodecPool.returnCodec
        writer.close();
    }
}
