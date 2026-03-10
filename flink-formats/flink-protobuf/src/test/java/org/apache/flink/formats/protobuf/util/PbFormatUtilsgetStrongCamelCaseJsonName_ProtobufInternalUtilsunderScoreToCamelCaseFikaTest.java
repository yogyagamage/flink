package org.apache.flink.formats.protobuf.util;

import com.google.protobuf.ProtobufInternalUtils;
import org.junit.jupiter.api.Test;

class PbFormatUtilsgetStrongCamelCaseJsonName_ProtobufInternalUtilsunderScoreToCamelCaseFikaTest {

    @Test
    void testGetStrongCamelCaseJsonName() {
        PbFormatUtils instance = new PbFormatUtils();
        instance.getStrongCamelCaseJsonName("test_name");
    }
}
