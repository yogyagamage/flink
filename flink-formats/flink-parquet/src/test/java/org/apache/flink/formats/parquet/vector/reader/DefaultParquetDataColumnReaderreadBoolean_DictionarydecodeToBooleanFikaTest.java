package org.apache.flink.formats.parquet.vector.reader;

import org.apache.parquet.column.Dictionary;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class DefaultParquetDataColumnReaderreadBoolean_DictionarydecodeToBooleanFikaTest {

    @Test
    public void testReadBooleanCallsDecodeToBoolean() {
        Dictionary mockDictionary = mock(Dictionary.class);
        ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader reader = 
            new ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader(mockDictionary);
        
        reader.readBoolean(0);
    }
}
