package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.table.data.TimestampData;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.page.PageReader;
import org.apache.parquet.io.api.Binary;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.PrimitiveType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

import static org.mockito.Mockito.when;

public class TimestampColumnReaderdecodeInt96ToTimestamp_BinarylengthFikaTest {

    @Test
    public void testDecodeInt96ToTimestampInvokesBinaryLength() throws IOException {
        // Mock required dependencies for constructor
        ColumnDescriptor mockDescriptor = Mockito.mock(ColumnDescriptor.class);
        PageReader mockPageReader = Mockito.mock(PageReader.class);
        PrimitiveType mockPrimitiveType = Mockito.mock(PrimitiveType.class);
        
        // Configure mocks to avoid the "totalValueCount == 0" error
        when(mockPageReader.getTotalValueCount()).thenReturn(100L);
        
        // Configure descriptor to return appropriate primitive type
        when(mockDescriptor.getPrimitiveType()).thenReturn(mockPrimitiveType);
        when(mockPrimitiveType.getPrimitiveTypeName())
            .thenReturn(PrimitiveType.PrimitiveTypeName.INT96);
        
        // Create instance using constructor
        TimestampColumnReader reader = new TimestampColumnReader(true, mockDescriptor, mockPageReader);
        
        // Create a mock Dictionary that returns a Binary with length 12
        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        Binary mockBinary = Mockito.mock(Binary.class);
        when(mockDictionary.decodeToBinary(Mockito.anyInt())).thenReturn(mockBinary);
        when(mockBinary.length()).thenReturn(12);
        when(mockBinary.toByteBuffer()).thenReturn(
            ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN)
        );
        
        // Call the static entry point method
        TimestampColumnReader.decodeInt96ToTimestamp(true, mockDictionary, 0);
    }
}
