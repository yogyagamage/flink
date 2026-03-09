package org.apache.flink.formats.parquet.row;

import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.VarCharType;
import org.apache.parquet.io.api.RecordConsumer;
import org.apache.parquet.schema.GroupType;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.PrimitiveType;
import org.apache.parquet.schema.Types;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class ParquetRowDataWritermethod_ConfigurationgetFikaTest {

    @Test
    public void testConfigurationGetIsInvoked() {
        // Create a mock RecordConsumer
        RecordConsumer mockRecordConsumer = Mockito.mock(RecordConsumer.class);
        
        // Create a simple RowType with one field
        RowType rowType = RowType.of(
            new LogicalType[]{new VarCharType(255)},
            new String[]{"field1"}
        );
        
        // Create a proper MessageType (which implements GroupType)
        MessageType schema = Types.buildMessage()
            .required(PrimitiveType.PrimitiveTypeName.BINARY).named("field1")
            .named("test_schema");
        
        // Create a real Configuration with the required property
        Configuration conf = new Configuration();
        conf.set("parquet.avro.write-old-list-structure", "false");
        conf.set("parquet.avro.add-list-element-records", "false");
        
        // Instantiate the class under test
        ParquetRowDataWriter writer = new ParquetRowDataWriter(
            mockRecordConsumer,
            rowType,
            schema,
            false,
            conf
        );
    }
}
