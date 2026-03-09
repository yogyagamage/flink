package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.VarCharType;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

class ParquetSchemaConverterconvertToParquetType_PrimitiveBuilderasFikaTest {

    @Test
    void testConvertToParquetType() {
        // Create instance using the provided constructor
        ParquetSchemaConverter converter = new ParquetSchemaConverter();
        
        // Create required parameters
        String name = "testField";
        LogicalType type = new VarCharType(false, 100); // VARCHAR type that will trigger UTF8 path
        Configuration conf = new Configuration();
        
        // Call the entry point method
        ParquetSchemaConverter.convertToParquetType(name, type, conf);
    }
}
