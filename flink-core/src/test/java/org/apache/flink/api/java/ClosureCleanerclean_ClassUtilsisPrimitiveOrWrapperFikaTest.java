package org.apache.flink.api.java;

import org.apache.flink.api.common.ExecutionConfig;
import org.junit.jupiter.api.Test;

public class ClosureCleanerclean_ClassUtilsisPrimitiveOrWrapperFikaTest {

    @Test
    public void testCleanPathToClassUtilsIsPrimitiveOrWrapper() {
        // Create an object whose class is a primitive wrapper
        Integer primitiveWrapperObject = 42;
        
        // Call the entry point method with parameters that will trigger the path
        // Using TOP_LEVEL to avoid recursion, and false to skip serialization check
        ClosureCleaner.clean(
            primitiveWrapperObject,
            ExecutionConfig.ClosureCleanerLevel.TOP_LEVEL,
            false
        );
    }
}
