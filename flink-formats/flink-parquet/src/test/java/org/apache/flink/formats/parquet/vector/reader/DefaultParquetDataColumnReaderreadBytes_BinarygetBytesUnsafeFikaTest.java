package org.apache.flink.formats.parquet.vector.reader;

import org.apache.flink.formats.parquet.vector.reader.ParquetDataColumnReaderFactory.DefaultParquetDataColumnReader;
import org.apache.parquet.bytes.ByteBufferInputStream;
import org.apache.parquet.column.Dictionary;
import org.apache.parquet.column.values.ValuesReader;
import org.apache.parquet.io.api.Binary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.mockito.Mockito.when;

public class DefaultParquetDataColumnReaderreadBytes_BinarygetBytesUnsafeFikaTest {

    @Test
    public void testReadBytesInvokesGetBytesUnsafe() throws IOException {
        // Create mock ValuesReader that returns a Binary with actual bytes
        ValuesReader mockValuesReader = Mockito.mock(ValuesReader.class);
        byte[] testBytes = new byte[]{1, 2, 3};
        Binary mockBinary = Binary.fromReusedByteArray(testBytes);
        when(mockValuesReader.readBytes()).thenReturn(mockBinary);

        // Instantiate the class under test using the constructor with ValuesReader
        DefaultParquetDataColumnReader reader = 
            new DefaultParquetDataColumnReader(mockValuesReader);

        // Initialize the reader with some data so readBytes() can proceed
        ByteBuffer buffer = ByteBuffer.wrap(new byte[10]);
        ByteBufferInputStream inputStream = ByteBufferInputStream.wrap(buffer);
        reader.initFromPage(0, inputStream);

        // Call the entry point method - this should invoke Binary.getBytesUnsafe()
        reader.readBytes();
    }
}
