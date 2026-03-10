package org.apache.flink.formats.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import org.apache.flink.formats.protobuf.PbConstant;
import org.apache.flink.table.types.logical.ArrayType;
import org.apache.flink.table.types.logical.BigIntType;
import org.apache.flink.table.types.logical.BooleanType;
import org.apache.flink.table.types.logical.DoubleType;
import org.apache.flink.table.types.logical.FloatType;
import org.apache.flink.table.types.logical.IntType;
import org.apache.flink.table.types.logical.LogicalType;
import org.apache.flink.table.types.logical.MapType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.table.types.logical.VarBinaryType;
import org.apache.flink.table.types.logical.VarCharType;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PbToRowTypeUtilgenerateFieldTypeInformation_JavaTypeequalsFikaTest {

    @Test
    public void testGenerateRowType() {
        PbToRowTypeUtil util = new PbToRowTypeUtil();
        
        Descriptor mockDescriptor = mock(Descriptor.class);
        FieldDescriptor mockField = mock(FieldDescriptor.class);
        Descriptor mockMessageType = mock(Descriptor.class);
        FieldDescriptor mockKeyField = mock(FieldDescriptor.class);
        FieldDescriptor mockValueField = mock(FieldDescriptor.class);
        
        when(mockDescriptor.getFields()).thenReturn(java.util.Collections.singletonList(mockField));
        when(mockField.getName()).thenReturn("testField");
        when(mockField.getJavaType()).thenReturn(JavaType.STRING);
        when(mockField.isMapField()).thenReturn(false);
        when(mockField.isRepeated()).thenReturn(false);
        when(mockField.getMessageType()).thenReturn(mockMessageType);
        
        when(mockMessageType.findFieldByName(PbConstant.PB_MAP_KEY_NAME)).thenReturn(mockKeyField);
        when(mockMessageType.findFieldByName(PbConstant.PB_MAP_VALUE_NAME)).thenReturn(mockValueField);
        
        when(mockKeyField.getJavaType()).thenReturn(JavaType.STRING);
        when(mockKeyField.isMapField()).thenReturn(false);
        when(mockKeyField.isRepeated()).thenReturn(false);
        when(mockKeyField.getMessageType()).thenReturn(null);
        
        when(mockValueField.getJavaType()).thenReturn(JavaType.STRING);
        when(mockValueField.isMapField()).thenReturn(false);
        when(mockValueField.isRepeated()).thenReturn(false);
        when(mockValueField.getMessageType()).thenReturn(null);
        
        PbToRowTypeUtil.generateRowType(mockDescriptor, false);
    }
}
