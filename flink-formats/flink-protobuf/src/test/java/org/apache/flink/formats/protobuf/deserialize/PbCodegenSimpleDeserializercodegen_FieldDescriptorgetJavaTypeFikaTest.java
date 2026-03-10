package org.apache.flink.formats.protobuf.deserialize;

import com.google.protobuf.Descriptors;
import org.apache.flink.formats.protobuf.PbCodegenException;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.LogicalTypeRoot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PbCodegenSimpleDeserializercodegen_FieldDescriptorgetJavaTypeFikaTest {

    @Test
    void testCodegen() throws PbCodegenException {
        Descriptors.FieldDescriptor mockFieldDescriptor = Mockito.mock(Descriptors.FieldDescriptor.class);
        Mockito.when(mockFieldDescriptor.getJavaType()).thenReturn(Descriptors.FieldDescriptor.JavaType.INT);
        
        LogicalType mockLogicalType = Mockito.mock(LogicalType.class);
        Mockito.when(mockLogicalType.getTypeRoot()).thenReturn(LogicalTypeRoot.INTEGER);
        
        PbCodegenSimpleDeserializer deserializer = new PbCodegenSimpleDeserializer(
            mockFieldDescriptor,
            mockLogicalType
        );
        
        deserializer.codegen("resultVar", "pbObjectCode", 0);
    }
}
