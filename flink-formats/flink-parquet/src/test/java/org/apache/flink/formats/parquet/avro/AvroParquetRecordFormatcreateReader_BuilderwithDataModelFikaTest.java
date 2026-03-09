package org.apache.flink.formats.parquet.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FSDataInputStream;
import org.apache.flink.util.function.SerializableSupplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AvroParquetRecordFormatcreateReader_BuilderwithDataModelFikaTest {

    @Test
    void testCreateReaderCallsWithDataModel() throws IOException {
        // Create mock TypeInformation
        TypeInformation<GenericRecord> mockTypeInfo = mock(TypeInformation.class);
        
        // Create a real SerializableSupplier that returns a real GenericData
        SerializableSupplier<GenericData> dataModelSupplier = () -> new GenericData();
        
        // Instantiate the class under test using the provided constructor
        AvroParquetRecordFormat<GenericRecord> format = 
            new AvroParquetRecordFormat<>(mockTypeInfo, dataModelSupplier);
        
        // Create mock FSDataInputStream
        FSDataInputStream mockStream = mock(FSDataInputStream.class);
        when(mockStream.getPos()).thenReturn(0L);
        
        // Create a real Configuration
        Configuration config = new Configuration();
        
        // Create a minimal valid Parquet file header in memory
        byte[] parquetHeader = new byte[] {
            'P', 'A', 'R', '1', // Magic number
            0, 0, 0, 0, // File metadata length (0 for simplicity)
            'P', 'A', 'R', '1'  // Magic number footer
        };
        
        ByteArrayInputStream bais = new ByteArrayInputStream(parquetHeader);
        when(mockStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt()))
            .thenAnswer(invocation -> {
                byte[] buffer = invocation.getArgument(0);
                int offset = invocation.getArgument(1);
                int length = invocation.getArgument(2);
                return bais.read(buffer, offset, length);
            });
        
        when(mockStream.read()).thenReturn(bais.read());
        
        // Call the entry point method
        format.createReader(config, mockStream, parquetHeader.length, parquetHeader.length);
    }
}
