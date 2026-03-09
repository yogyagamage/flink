package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.*;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

public class ParquetSchemaConverterconvertToParquetType_PrimitiveBuilderasFikaTest2 {

    @Test
    public void testConvertToParquetTypeInvokesPrimitiveBuilderAs() {
        ParquetSchemaConverter converter = new ParquetSchemaConverter();
        Configuration conf = new Configuration();
        
        // Set configuration to trigger the INT64 timestamp path which uses .as(LogicalTypeAnnotation)
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), true);
        conf.set(IDENTIFIER + "." + TIMESTAMP_TIME_UNIT.key(), "MILLIS");
        
        // Use TIMESTAMP_WITHOUT_TIME_ZONE to hit the branch with .as(LogicalTypeAnnotation.timestampType(...))
        LogicalType timestampType = new TimestampType(false, 3);
        
        converter.convertToParquetType("testField", timestampType, conf);
    }
}
