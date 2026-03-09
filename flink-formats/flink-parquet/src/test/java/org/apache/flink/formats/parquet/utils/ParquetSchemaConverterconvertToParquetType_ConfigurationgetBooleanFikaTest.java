package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.TimestampType;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

public class ParquetSchemaConverterconvertToParquetType_ConfigurationgetBooleanFikaTest {

    @Test
    public void testConvertToParquetTypeTriggersConfigurationGetBoolean() {
        // Create a Configuration instance
        Configuration conf = new Configuration();
        
        // Set the configuration property that will be read by getBoolean
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), true);
        conf.set(IDENTIFIER + "." + TIMESTAMP_TIME_UNIT.key(), "MILLIS");
        
        // Create a TimestampType (which will take the TIMESTAMP_WITHOUT_TIME_ZONE path)
        LogicalType timestampType = new TimestampType(false, 3);
        
        // Call the entry point method
        ParquetSchemaConverter.convertToParquetType("testField", timestampType, conf);
    }
}
