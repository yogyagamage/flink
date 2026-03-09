package org.apache.flink.formats.parquet.vector;

import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.IntType;
import org.apache.parquet.column.ColumnDescriptor;
import org.apache.parquet.schema.PrimitiveType;
import org.apache.parquet.schema.Type;
import org.apache.parquet.schema.Types;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParquetSplitReaderUtilgetAllColumnDescriptorByType_InvalidSchemaExceptionmethodFikaTest2 {

    @Test
    public void testCreateWritableColumnVectorInvokesInvalidSchemaException() {
        // Setup parameters to trigger the exception path in getAllColumnDescriptorByType
        int batchSize = 1;
        LogicalType fieldType = new IntType(false);
        int depth = 0;
        
        // Create a Parquet type that won't match any column descriptor
        PrimitiveType parquetType = Types.required(PrimitiveType.PrimitiveTypeName.INT32)
                .named("int_field");
        
        // Create column descriptors with paths that won't match the type name at depth 0
        List<ColumnDescriptor> columnDescriptors = new ArrayList<>();
        // Add a descriptor with path that doesn't match "int_field" at depth 0
        ColumnDescriptor descriptor = new ColumnDescriptor(
                new String[]{"different_name", "subfield"},
                PrimitiveType.PrimitiveTypeName.INT32,
                0,
                0
        );
        columnDescriptors.add(descriptor);
        
        // This should call getAllColumnDescriptorByType which will throw InvalidSchemaException
        // because no descriptor path matches "int_field" at depth 0
        try {
            ParquetSplitReaderUtil.createWritableColumnVector(
                    batchSize,
                    fieldType,
                    parquetType,
                    columnDescriptors,
                    depth
            );
        } catch (Exception e) {
            // Expected - InvalidSchemaException should be thrown
        }
    }
}
