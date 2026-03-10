package org.apache.flink.formats.protobuf.util;

import com.google.protobuf.Descriptors;
import org.apache.flink.formats.protobuf.PbFormatContext;
import org.apache.flink.formats.protobuf.PbFormatConfig;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PbCodegenUtilspbDefaultValueCode_FieldDescriptorgetJavaTypeFikaTest {

    @Test
    public void testPbDefaultValueCode() throws Exception {
        PbCodegenUtils instance = new PbCodegenUtils();
        
        Descriptors.FieldDescriptor fieldDescriptor = mock(Descriptors.FieldDescriptor.class);
        PbFormatConfig formatConfig = mock(PbFormatConfig.class);
        PbFormatContext pbFormatContext = mock(PbFormatContext.class);
        
        when(pbFormatContext.getPbFormatConfig()).thenReturn(formatConfig);
        when(formatConfig.getWriteNullStringLiterals()).thenReturn("null");
        when(fieldDescriptor.getJavaType()).thenReturn(Descriptors.FieldDescriptor.JavaType.INT);
        
        PbCodegenUtils.pbDefaultValueCode(fieldDescriptor, pbFormatContext);
    }
}
