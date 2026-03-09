package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.table.data.TimestampData;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.page.PageReader;
import org.apache.parquet.schema.LogicalTypeAnnotation;
import org.apache.parquet.schema.PrimitiveType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.when;

public class TimestampColumnReaderdecodeInt64ToTimestamp_DictionarydecodeToLongFikaTest {

    @Test
    public void testDecodeInt64ToTimestampCallsDictionaryDecodeToLong() throws IOException {
        ColumnDescriptor mockDescriptor = Mockito.mock(ColumnDescriptor.class);
        PageReader mockPageReader = Mockito.mock(PageReader.class);
        PrimitiveType mockPrimitiveType = Mockito.mock(PrimitiveType.class);
        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        
        when(mockDescriptor.getPrimitiveType()).thenReturn(mockPrimitiveType);
        when(mockPrimitiveType.getPrimitiveTypeName()).thenReturn(PrimitiveType.PrimitiveTypeName.INT64);
        
        LogicalTypeAnnotation.TimestampLogicalTypeAnnotation mockTimestampType = 
            Mockito.mock(LogicalTypeAnnotation.TimestampLogicalTypeAnnotation.class);
        when(mockPrimitiveType.getLogicalTypeAnnotation()).thenReturn(mockTimestampType);
        when(mockTimestampType.getUnit()).thenReturn(LogicalTypeAnnotation.TimeUnit.MILLIS);
        
        when(mockPageReader.getTotalValueCount()).thenReturn(100L);
        
        TimestampColumnReader reader = new TimestampColumnReader(true, mockDescriptor, mockPageReader);
        
        TimestampColumnReader.decodeInt64ToTimestamp(true, mockDictionary, 1, LogicalTypeAnnotation.TimeUnit.MILLIS);
    }
}
