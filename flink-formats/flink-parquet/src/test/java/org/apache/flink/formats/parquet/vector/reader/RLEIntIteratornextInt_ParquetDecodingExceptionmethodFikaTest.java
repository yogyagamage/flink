package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.NestedPrimitiveColumnReader.RLEIntIterator;
import org.apache.parquet.column.values.rle.RunLengthBitPackingHybridDecoder;
import org.apache.parquet.io.ParquetDecodingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class RLEIntIteratornextInt_ParquetDecodingExceptionmethodFikaTest {

    @Test
    void test() throws Exception {
        RunLengthBitPackingHybridDecoder mockDecoder = Mockito.mock(RunLengthBitPackingHybridDecoder.class);
        Mockito.when(mockDecoder.readInt()).thenThrow(new IOException("Test exception"));
        
        RLEIntIterator iterator = new RLEIntIterator(mockDecoder);
        try {
            iterator.nextInt();
        } catch (ParquetDecodingException e) {
            // Expected - third-party method was invoked
        }
    }
}
