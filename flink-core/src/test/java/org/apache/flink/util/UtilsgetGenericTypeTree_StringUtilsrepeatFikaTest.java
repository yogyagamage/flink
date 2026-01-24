package org.apache.flink.util;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.GenericTypeInfo;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UtilsgetGenericTypeTree_StringUtilsrepeatFikaTest {

    @Test
    public void testGetSerializerTreeInvokesStringUtilsRepeat() {
        // Create a GenericTypeInfo for a class with fields to trigger the path
        GenericTypeInfo<Date> typeInfo = new GenericTypeInfo<>(Date.class);
        
        // This will traverse the call chain:
        // Utils.getSerializerTree(TypeInformation) -> 
        // Utils.getSerializerTree(TypeInformation, int) -> 
        // Utils.getGenericTypeTree(Class, int) -> 
        // StringUtils.repeat(char, int)
        Utils.getSerializerTree(typeInfo);
    }
}
