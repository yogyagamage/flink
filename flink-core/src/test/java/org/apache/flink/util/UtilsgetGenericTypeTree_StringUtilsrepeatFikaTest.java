package org.apache.flink.util;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.GenericTypeInfo;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UtilsgetGenericTypeTree_StringUtilsrepeatFikaTest {

    @Test
    public void testGetSerializerTreeInvokesStringUtilsRepeat() {
        // Create a GenericTypeInfo that will trigger the path to StringUtils.repeat
        TypeInformation<Date> typeInfo = new GenericTypeInfo<>(Date.class);
        
        // This call should traverse:
        // 1. Utils.getSerializerTree(TypeInformation) 
        // 2. Utils.getSerializerTree(TypeInformation, int)
        // 3. Utils.getGenericTypeTree(Class, int)
        // 4. StringUtils.repeat(char, int)
        Utils.getSerializerTree(typeInfo);
    }
}
