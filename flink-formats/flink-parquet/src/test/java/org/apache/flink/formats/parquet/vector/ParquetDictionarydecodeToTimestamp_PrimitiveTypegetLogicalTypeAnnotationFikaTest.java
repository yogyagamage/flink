package org.apache.flink.formats.parquet.vector;

import org.apache.flink.table.data.TimestampData;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.PrimitiveType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ParquetDictionarydecodeToTimestamp_PrimitiveTypegetLogicalTypeAnnotationFikaTest {

    @Test
    public void testDecodeToTimestampInvokesGetLogicalTypeAnnotation() {
        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        ColumnDescriptor mockDescriptor = Mockito.mock(ColumnDescriptor.class);
        PrimitiveType mockPrimitiveType = Mockito.mock(PrimitiveType.class);
        LogicalTypeAnnotation.TimestampLogicalTypeAnnotation mockTimestampAnnotation = 
            Mockito.mock(LogicalTypeAnnotation.TimestampLogicalTypeAnnotation.class);
        
        when(mockDescriptor.getPrimitiveType()).thenReturn(mockPrimitiveType);
        when(mockPrimitiveType.getPrimitiveTypeName()).thenReturn(PrimitiveType.PrimitiveTypeName.INT64);
        when(mockPrimitiveType.getLogicalTypeAnnotation()).thenReturn(mockTimestampAnnotation);
        when(mockTimestampAnnotation.getUnit()).thenReturn(LogicalTypeAnnotation.TimeUnit.MILLIS);
        
        ParquetDictionary dictionary = new ParquetDictionary(mockDictionary, mockDescriptor);
        dictionary.decodeToTimestamp(0);
    }
}
