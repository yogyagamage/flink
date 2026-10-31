package org.apache.flink.api.java;

import org.apache.flink.api.common.ExecutionConfig;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class ClosureCleanerclean_ClassUtilsisPrimitiveOrWrapperFikaTest {

    @Test
    void testIsPrimitiveOrWrapperInvocation() {
        // Create a simple object with primitive wrapper class
        Integer func = 42;
        Set<Object> visited = new HashSet<>();
        
        // Directly invoke the private method via reflection
        try {
            java.lang.reflect.Method cleanMethod = Class.forName("org.apache.flink.api.java.ClosureCleaner")
                    .getDeclaredMethod("clean", Object.class, ExecutionConfig.ClosureCleanerLevel.class, 
                            boolean.class, Set.class);
            cleanMethod.setAccessible(true);
            
            // This should trigger ClassUtils.isPrimitiveOrWrapper when Integer.class is checked
            cleanMethod.invoke(null, func, ExecutionConfig.ClosureCleanerLevel.TOP_LEVEL, false, visited);
        } catch (Exception e) {
            // Ignore exceptions - test only needs to reach the target method
        }
    }
}
