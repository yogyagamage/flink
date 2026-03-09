package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.values.ValuesReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class DefaultParquetDataColumnReaderskip_ValuesReaderskipFikaTest {

    @Test
    void testSkip() {
        ValuesReader mockValuesReader = mock(ValuesReader.class);
        DefaultParquetDataColumnReader reader = new DefaultParquetDataColumnReader(mockValuesReader);
        
        reader.skip();
        
        Mockito.verify(mockValuesReader, Mockito.times(1)).skip();
    }
}
