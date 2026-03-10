package org.apache.flink.orc.writer;

import org.apache.flink.orc.vector.Vectorizer;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.orc.TypeDescription;
import org.apache.orc.Writer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class OrcBulkWriteraddElement_WriteraddRowBatchFikaTest {

    @Test
    void testAddElementTriggersAddRowBatch() throws IOException {
        // Create mock dependencies
        Vectorizer<String> mockVectorizer = Mockito.mock(Vectorizer.class);
        Writer mockWriter = Mockito.mock(Writer.class);
        
        // Create a real VectorizedRowBatch with size equal to maxSize
        TypeDescription mockSchema = Mockito.mock(TypeDescription.class);
        VectorizedRowBatch realRowBatch = new VectorizedRowBatch(1, 1024);
        realRowBatch.size = 1024; // Set size equal to maxSize
        
        // Configure mocks
        Mockito.when(mockVectorizer.getSchema()).thenReturn(mockSchema);
        Mockito.when(mockSchema.createRowBatch()).thenReturn(realRowBatch);
        
        // Create the class under test
        OrcBulkWriter<String> writer = new OrcBulkWriter<>(mockVectorizer, mockWriter);
        
        // Call the entry point method
        writer.addElement("test-element");
    }
}
