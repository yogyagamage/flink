package org.apache.flink.formats.parquet.avro;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FSDataInputStream;
import org.apache.flink.util.function.SerializableSupplier;
import org.apache.avro.generic.GenericData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class AvroParquetRecordFormatcreateReader_AvroParquetReaderbuilderFikaTest {

    @Test
    public void testCreateReaderInvokesAvroParquetReaderBuilder() throws IOException {
        TypeInformation<GenericData.Record> typeInformation = Mockito.mock(TypeInformation.class);
        SerializableSupplier<GenericData> dataModelSupplier = () -> new GenericData();
        
        AvroParquetRecordFormat<GenericData.Record> format = 
            new AvroParquetRecordFormat<>(typeInformation, dataModelSupplier);
        
        Configuration config = new Configuration();
        FSDataInputStream stream = Mockito.mock(FSDataInputStream.class);
        long fileLen = 100L;
        long splitEnd = 100L;
        
        format.createReader(config, stream, fileLen, splitEnd);
    }
}
