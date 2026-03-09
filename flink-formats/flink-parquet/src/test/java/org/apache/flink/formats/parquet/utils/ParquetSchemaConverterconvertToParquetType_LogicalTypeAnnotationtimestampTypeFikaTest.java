package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.TimestampType;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

public class ParquetSchemaConverterconvertToParquetType_LogicalTypeAnnotationtimestampTypeFikaTest {

    @Test
    public void testConvertToParquetTypeTriggersTimestampType() {
        // Create configuration that will trigger the timestamp branch
        Configuration conf = new Configuration();
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), true);
        conf.set(IDENTIFIER + "." + TIMESTAMP_TIME_UNIT.key(), "millis");

        // Create a timestamp type that will follow the desired path
        LogicalType timestampType = new TimestampType(false, 3);

        // Call the entry point method
        ParquetSchemaConverter.convertToParquetType("testField", timestampType, conf);
    }
}
