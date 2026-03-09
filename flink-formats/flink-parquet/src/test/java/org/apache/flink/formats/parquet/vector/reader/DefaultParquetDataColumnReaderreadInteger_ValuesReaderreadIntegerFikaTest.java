package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.values.ValuesReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.doNothing;

class DefaultParquetDataColumnReaderreadInteger_ValuesReaderreadIntegerFikaTest {

    @Test
    void testReadInteger() throws IOException {
        ValuesReader mockValuesReader = Mockito.mock(ValuesReader.class);
        Mockito.when(mockValuesReader.readInteger()).thenReturn(0);
        
        DefaultParquetDataColumnReader reader = 
            new DefaultParquetDataColumnReader(mockValuesReader);
        
        reader.readInteger();
    }
}
