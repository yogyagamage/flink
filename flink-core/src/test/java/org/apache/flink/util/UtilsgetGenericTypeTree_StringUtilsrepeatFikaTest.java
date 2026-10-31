package org.apache.flink.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class UtilsgetGenericTypeTree_StringUtilsrepeatFikaTest {

    static class Sample {
        int value;
    }

    @Test
    void testGetGenericTypeTreeInvokesStringUtilsRepeat() throws Exception {
        Method method = Utils.class.getDeclaredMethod("getGenericTypeTree", Class.class, int.class);
        method.setAccessible(true);
        method.invoke(null, Sample.class, 0);
    }
}
