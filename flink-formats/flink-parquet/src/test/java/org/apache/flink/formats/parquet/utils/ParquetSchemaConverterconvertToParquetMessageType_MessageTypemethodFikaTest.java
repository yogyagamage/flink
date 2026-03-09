package org.apache.flink.formats.parquet.utils;

import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.hadoop.conf.Configuration;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.Type;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ParquetSchemaConverterconvertToParquetMessageType_MessageTypemethodFikaTest {

    @Test
    public void testConvertToParquetMessageType() {
        ParquetSchemaConverter converter = new ParquetSchemaConverter();
        
        String name = "testSchema";
        Configuration conf = new Configuration();
        
        RowType rowType = RowType.of(
            new LogicalType[]{},
            new String[]{}
        );
        
        converter.convertToParquetMessageType(name, rowType, conf);
    }
}
