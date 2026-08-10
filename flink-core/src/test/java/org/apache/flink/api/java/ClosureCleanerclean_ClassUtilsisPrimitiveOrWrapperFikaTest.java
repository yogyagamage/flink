package org.apache.flink.api.java;

import org.apache.flink.api.common.ExecutionConfig;
import org.apache.commons.lang3.ClassUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class ClosureCleanerclean_ClassUtilsisPrimitiveOrWrapperFikaTest {

    @Test
    public void testCleanPathToClassUtilsIsPrimitiveOrWrapper() {
        // Create an object that will trigger the ClassUtils.isPrimitiveOrWrapper call
        // Using a primitive wrapper class object
        Integer primitiveWrapperObject = 42;
        
        // Call the entry point method with appropriate parameters
        ClosureCleaner.clean(
            primitiveWrapperObject,
            ExecutionConfig.ClosureCleanerLevel.TOP_LEVEL,
            false
        );
    }
}
