package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.TimestampType;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

class ParquetSchemaConverterconvertToParquetType_ConfigurationgetFikaTest {

    @Test
    void testConvertToParquetTypeTriggersConfigurationGet() {
        // Create a Configuration instance
        Configuration conf = new Configuration();
        
        // Set the required configuration properties to ensure the code path
        // reaches the Configuration.get() call
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), true);
        conf.set(IDENTIFIER + "." + TIMESTAMP_TIME_UNIT.key(), "MILLIS");
        
        // Create a TimestampType which will trigger the Configuration.get() call
        LogicalType timestampType = new TimestampType(false, 3);
        
        // Call the entry point method
        ParquetSchemaConverter.convertToParquetType("testField", timestampType, conf);
    }
}
