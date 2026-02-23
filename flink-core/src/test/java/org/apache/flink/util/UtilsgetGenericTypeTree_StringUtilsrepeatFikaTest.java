package org.apache.flink.util;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.GenericTypeInfo;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UtilsgetGenericTypeTree_StringUtilsrepeatFikaTest {

    @Test
    public void testGetSerializerTreeInvokesStringUtilsRepeat() {
        // Create a GenericTypeInfo with a class that has non-static, non-transient fields
        GenericTypeInfo<Date> genericTypeInfo = new GenericTypeInfo<>(Date.class);
        
        // This will trigger the path: getSerializerTree -> getSerializerTree -> getGenericTypeTree -> StringUtils.repeat
        Utils.getSerializerTree(genericTypeInfo);
    }
}
