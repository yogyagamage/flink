package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.values.ValuesReader;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class DefaultParquetDataColumnReaderreadSmallInt_ValuesReaderreadIntegerFikaTest {

    @Test
    void testReadSmallIntCallsReadInteger() throws Exception {
        ValuesReader mockValuesReader = mock(ValuesReader.class);
        DefaultParquetDataColumnReader reader = new DefaultParquetDataColumnReader(mockValuesReader);
        reader.readSmallInt();
    }
}
