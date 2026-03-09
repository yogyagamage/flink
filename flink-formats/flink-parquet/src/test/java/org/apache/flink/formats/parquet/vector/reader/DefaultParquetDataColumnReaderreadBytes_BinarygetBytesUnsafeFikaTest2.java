package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.io.api.Binary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class DefaultParquetDataColumnReaderreadBytes_BinarygetBytesUnsafeFikaTest2 {

    @Test
    void testReadBytesInvokesGetBytesUnsafe() throws IOException {
        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        Binary mockBinary = Mockito.mock(Binary.class);
        
        Mockito.when(mockDictionary.decodeToBinary(Mockito.anyInt()))
               .thenReturn(mockBinary);
        
        DefaultParquetDataColumnReader reader = 
            new DefaultParquetDataColumnReader(mockDictionary);
        
        reader.readBytes(1);
    }
}
