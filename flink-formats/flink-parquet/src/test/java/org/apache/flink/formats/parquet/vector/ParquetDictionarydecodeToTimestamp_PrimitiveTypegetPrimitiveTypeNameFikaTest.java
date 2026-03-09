package org.apache.flink.formats.parquet.vector;

import org.apache.flink.table.data.TimestampData;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.PrimitiveType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ParquetDictionarydecodeToTimestamp_PrimitiveTypegetPrimitiveTypeNameFikaTest {

    @Test
    public void testDecodeToTimestampInvokesGetPrimitiveTypeName() {
        // Create mock Dictionary
        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        
        // Create mock ColumnDescriptor with proper PrimitiveType setup
        ColumnDescriptor mockDescriptor = Mockito.mock(ColumnDescriptor.class);
        PrimitiveType mockPrimitiveType = Mockito.mock(PrimitiveType.class);
        
        // Setup the mock chain to reach getPrimitiveTypeName()
        when(mockDescriptor.getPrimitiveType()).thenReturn(mockPrimitiveType);
        when(mockPrimitiveType.getPrimitiveTypeName()).thenReturn(PrimitiveType.PrimitiveTypeName.INT64);
        
        // Create TimestampLogicalTypeAnnotation mock
        LogicalTypeAnnotation.TimestampLogicalTypeAnnotation mockTimestampAnnotation = 
            Mockito.mock(LogicalTypeAnnotation.TimestampLogicalTypeAnnotation.class);
        when(mockPrimitiveType.getLogicalTypeAnnotation()).thenReturn(mockTimestampAnnotation);
        when(mockTimestampAnnotation.getUnit()).thenReturn(LogicalTypeAnnotation.TimeUnit.MILLIS);
        
        // Instantiate ParquetDictionary using the constructor
        ParquetDictionary parquetDictionary = new ParquetDictionary(mockDictionary, mockDescriptor);
        
        // Call the entry point method - this should trigger getPrimitiveTypeName()
        TimestampData result = parquetDictionary.decodeToTimestamp(1);
    }
}
