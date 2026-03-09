package org.apache.flink.formats.parquet.vector;

import org.apache.flink.table.data.TimestampData;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.PrimitiveType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ParquetDictionarydecodeToTimestamp_TimestampLogicalTypeAnnotationgetUnitFikaTest {

    @Test
    public void testDecodeToTimestampInvokesGetUnit() {
        Dictionary dictionary = Mockito.mock(Dictionary.class);
        ColumnDescriptor descriptor = Mockito.mock(ColumnDescriptor.class);
        PrimitiveType primitiveType = Mockito.mock(PrimitiveType.class);
        LogicalTypeAnnotation.TimestampLogicalTypeAnnotation timestampAnnotation = 
            Mockito.mock(LogicalTypeAnnotation.TimestampLogicalTypeAnnotation.class);

        when(descriptor.getPrimitiveType()).thenReturn(primitiveType);
        when(primitiveType.getPrimitiveTypeName()).thenReturn(PrimitiveType.PrimitiveTypeName.INT64);
        when(primitiveType.getLogicalTypeAnnotation()).thenReturn(timestampAnnotation);
        when(timestampAnnotation.getUnit()).thenReturn(LogicalTypeAnnotation.TimeUnit.MILLIS);

        ParquetDictionary parquetDictionary = new ParquetDictionary(dictionary, descriptor);
        parquetDictionary.decodeToTimestamp(0);
    }
}
