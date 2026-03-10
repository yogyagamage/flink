package org.apache.flink.formats.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import org.apache.flink.api.common.InvalidProgramException;
import org.apache.flink.formats.protobuf.PbCodegenException;
import org.apache.flink.formats.protobuf.PbConstant;
import org.codehaus.janino.SimpleCompiler;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PbCodegenUtilsgetTypeStrFromProto_DescriptorfindFieldByNameFikaTest {

    @Test
    public void testGetTypeStrFromProtoTriggersFindFieldByName() throws PbCodegenException {
        FieldDescriptor mockFieldDescriptor = mock(FieldDescriptor.class);
        Descriptor mockMessageType = mock(Descriptor.class);
        FieldDescriptor mockKeyFd = mock(FieldDescriptor.class);
        FieldDescriptor mockValueFd = mock(FieldDescriptor.class);
        
        when(mockFieldDescriptor.getJavaType()).thenReturn(JavaType.MESSAGE);
        when(mockFieldDescriptor.isMapField()).thenReturn(true);
        when(mockFieldDescriptor.getMessageType()).thenReturn(mockMessageType);
        
        when(mockMessageType.findFieldByName(PbConstant.PB_MAP_KEY_NAME)).thenReturn(mockKeyFd);
        when(mockMessageType.findFieldByName(PbConstant.PB_MAP_VALUE_NAME)).thenReturn(mockValueFd);
        
        when(mockKeyFd.getJavaType()).thenReturn(JavaType.STRING);
        when(mockValueFd.getJavaType()).thenReturn(JavaType.STRING);
        
        PbCodegenUtils.getTypeStrFromProto(mockFieldDescriptor, false);
    }
}
