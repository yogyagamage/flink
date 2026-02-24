package org.apache.flink.api.java;

import org.apache.flink.api.common.ExecutionConfig;
import org.junit.jupiter.api.Test;

public class ClosureCleanerclean_ClassUtilsisPrimitiveOrWrapperFikaTest {

    @Test
    public void testCleanPathToClassUtilsIsPrimitiveOrWrapper() {
        // Create a simple object that will trigger the primitive/wrapper check
        Integer integerObject = 42;
        
        // Call the entry point method with parameters that will reach the third-party method
        ClosureCleaner.clean(
            integerObject,
            ExecutionConfig.ClosureCleanerLevel.TOP_LEVEL,
            false
        );
    }
}
