package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.TimestampType;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

public class ParquetSchemaConverterconvertToParquetType_TimeUnitvalueOfFikaTest {

    @Test
    public void testConvertToParquetTypeTriggersTimeUnitValueOf() {
        // Create instance using the provided constructor
        ParquetSchemaConverter converter = new ParquetSchemaConverter();
        
        // Create configuration that will trigger the TIMESTAMP_WITHOUT_TIME_ZONE case
        Configuration conf = new Configuration();
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), true);
        conf.set(IDENTIFIER + "." + TIMESTAMP_TIME_UNIT.key(), "MILLIS");
        
        // Create a TIMESTAMP_WITHOUT_TIME_ZONE logical type
        LogicalType timestampType = new TimestampType(false, 3);
        
        // Call the entry point method - this should trigger the chain that calls
        // LogicalTypeAnnotation.TimeUnit.valueOf()
        ParquetSchemaConverter.convertToParquetType("testField", timestampType, conf);
    }
}
