package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.*;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.IDENTIFIER;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.TIMESTAMP_TIME_UNIT;
import static org.apache.flink.formats.parquet.ParquetFileFormatFactory.WRITE_INT64_TIMESTAMP;

public class ParquetSchemaConverterconvertToParquetType_PrimitiveBuildernamedFikaTest {

    @Test
    public void testConvertToParquetTypeInvokesPrimitiveBuilderNamed() {
        ParquetSchemaConverter converter = new ParquetSchemaConverter();
        
        Configuration conf = new Configuration();
        conf.setBoolean(IDENTIFIER + "." + WRITE_INT64_TIMESTAMP.key(), false);
        
        LogicalType logicalType = new VarCharType(255);
        
        converter.convertToParquetType("testField", logicalType, conf);
    }
}
