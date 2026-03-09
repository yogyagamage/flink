package org.apache.flink.formats.parquet.vector.reader;

import org.apache.parquet.column.Dictionary;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class DefaultParquetDataColumnReaderreadSmallInt_DictionarydecodeToIntFikaTest {

    @Test
    public void testReadSmallInt() {
        Dictionary mockDictionary = mock(Dictionary.class);
        ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader reader = 
            new ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader(mockDictionary);
        
        reader.readSmallInt(0);
    }
}
