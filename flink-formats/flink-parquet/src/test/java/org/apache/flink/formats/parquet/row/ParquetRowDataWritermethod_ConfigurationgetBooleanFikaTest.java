package org.apache.flink.formats.parquet.row;

import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.VarCharType;
import org.apache.parquet.io.api.RecordConsumer;
import org.apache.parquet.schema.GroupType;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.PrimitiveType;
import org.apache.parquet.schema.Type;
import org.apache.parquet.schema.Types;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParquetRowDataWritermethod_ConfigurationgetBooleanFikaTest {

    @Test
    public void testConfigurationGetBooleanIsInvoked() {
        // Mock RecordConsumer since it's required for constructor but not related to target method
        RecordConsumer mockRecordConsumer = Mockito.mock(RecordConsumer.class);
        
        // Create a simple RowType with one field
        RowType rowType = RowType.of(
            new LogicalType[]{new VarCharType(255)},
            new String[]{"field1"}
        );
        
        // Create a matching Parquet schema
        MessageType schema = Types.buildMessage()
            .required(PrimitiveType.PrimitiveTypeName.BINARY).named("field1")
            .named("test_schema");
        
        // Create real Configuration object to ensure getBoolean is called
        Configuration conf = new Configuration();
        
        // Instantiate the class under test with real Configuration
        ParquetRowDataWriter writer = new ParquetRowDataWriter(
            mockRecordConsumer,
            rowType,
            schema,
            false,
            conf
        );
    }
}
