package org.apache.flink.formats.parquet.vector.reader;

import org.apache.parquet.column.values.ValuesReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DefaultParquetDataColumnReaderreadTinyInt_ValuesReaderreadIntegerFikaTest {

    @Test
    void testReadTinyInt() {
        ValuesReader mockValuesReader = Mockito.mock(ValuesReader.class);
        ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader reader = 
            new ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader(mockValuesReader);
        
        reader.readTinyInt();
    }
}
