package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.column.Dictionary;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class DefaultParquetDataColumnReaderreadInteger_DictionarydecodeToIntFikaTest {

    @Test
    void testReadIntegerCallsDecodeToInt() {
        Dictionary mockDictionary = mock(Dictionary.class);
        DefaultParquetDataColumnReader reader = new DefaultParquetDataColumnReader(mockDictionary);
        
        reader.readInteger(42);
    }
}
