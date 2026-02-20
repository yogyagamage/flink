package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class UtilsgetGenericTypeTree_StringUtilsrepeatFikaTest {

    @Test
    void testGetGenericTypeTree() throws Exception {
        // Create a simple class with fields to trigger the StringUtils.repeat call
        class TestClass {
            private String testField;
            private int primitiveField;
            public static final String STATIC_FIELD = "static";
            transient String transientField;
        }
        
        // Invoke the private method via reflection
        java.lang.reflect.Method method = Utils.class.getDeclaredMethod(
            "getGenericTypeTree", 
            Class.class, 
            int.class
        );
        method.setAccessible(true);
        
        // Call with indent > 0 to ensure StringUtils.repeat is called
        method.invoke(null, TestClass.class, 2);
    }
}
