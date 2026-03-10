package org.apache.flink.orc.writer;

import org.apache.flink.core.fs.FSDataOutputStream;
import org.apache.orc.CompressionKind;
import org.apache.orc.OrcFile;
import org.apache.orc.TypeDescription;
import org.apache.orc.impl.HadoopShims;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhysicalWriterImplmethod_OrcCodecPoolgetCodecFikaTest {

    @Test
    void testOrcCodecPoolGetCodecInvocation() throws IOException {
        // Create mock FSDataOutputStream
        FSDataOutputStream mockOutputStream = mock(FSDataOutputStream.class);
        
        // Create mock WriterOptions
        OrcFile.WriterOptions mockWriterOptions = mock(OrcFile.WriterOptions.class);
        
        // Configure mock WriterOptions to ensure the code path reaches OrcCodecPool.getCodec
        when(mockWriterOptions.isEnforceBufferSize()).thenReturn(false);
        when(mockWriterOptions.getBufferSize()).thenReturn(256 * 1024);
        when(mockWriterOptions.getStripeSize()).thenReturn(64L * 1024 * 1024);
        
        // Create a simple schema
        TypeDescription schema = TypeDescription.createStruct()
                .addField("field1", TypeDescription.createInt());
        
        when(mockWriterOptions.getSchema()).thenReturn(schema);
        when(mockWriterOptions.getBlockSize()).thenReturn(256L * 1024 * 1024);
        when(mockWriterOptions.getPaddingTolerance()).thenReturn(0.0);
        when(mockWriterOptions.getCompress()).thenReturn(CompressionKind.NONE);
        when(mockWriterOptions.getHadoopShims()).thenReturn(mock(HadoopShims.class));
        when(mockWriterOptions.getBlockPadding()).thenReturn(false);
        when(mockWriterOptions.getWriteVariableLengthBlocks()).thenReturn(false);
        
        // Instantiate PhysicalWriterImpl - this will trigger the constructor
        // which should call OrcCodecPool.getCodec(this.compress)
        new PhysicalWriterImpl(mockOutputStream, mockWriterOptions);
    }
}
