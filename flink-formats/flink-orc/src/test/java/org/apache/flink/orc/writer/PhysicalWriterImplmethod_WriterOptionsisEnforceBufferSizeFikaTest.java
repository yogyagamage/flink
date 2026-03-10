package org.apache.flink.orc.writer;

import org.apache.flink.core.fs.FSDataOutputStream;
import org.apache.orc.OrcFile;
import org.apache.orc.TypeDescription;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PhysicalWriterImplmethod_WriterOptionsisEnforceBufferSizeFikaTest {

    @Test
    void testIsEnforceBufferSizeInvoked() throws IOException {
        // Create mock FSDataOutputStream
        FSDataOutputStream mockOutputStream = Mockito.mock(FSDataOutputStream.class);
        
        // Create real WriterOptions with minimal configuration
        OrcFile.WriterOptions writerOptions = OrcFile.writerOptions(null);
        writerOptions.setSchema(TypeDescription.fromString("struct<field:int>"));
        
        // Instantiate PhysicalWriterImpl - this will invoke opts.isEnforceBufferSize()
        new PhysicalWriterImpl(mockOutputStream, writerOptions);
    }
}
