package org.apache.flink.formats.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import org.apache.flink.formats.protobuf.PbCodegenException;
import org.apache.flink.formats.protobuf.PbConstant;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PbCodegenUtilsgetTypeStrFromProto_FieldDescriptorgetJavaTypeFikaTest {

    @Test
    public void testGetTypeStrFromProtoInvokesGetJavaType() throws PbCodegenException {
        FieldDescriptor mockFieldDescriptor = mock(FieldDescriptor.class);
        when(mockFieldDescriptor.getJavaType()).thenReturn(JavaType.INT);
        
        PbCodegenUtils.getTypeStrFromProto(mockFieldDescriptor, false);
    }
}
