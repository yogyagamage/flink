package org.apache.flink.api.java;

import org.apache.flink.api.common.ExecutionConfig;
import org.junit.jupiter.api.Test;

public class ClosureCleanerclean_ClassUtilsisPrimitiveOrWrapperFikaTest {

    @Test
    public void testCleanReachesClassUtilsIsPrimitiveOrWrapper() {
        ClosureCleaner.clean(Integer.valueOf(1), ExecutionConfig.ClosureCleanerLevel.RECURSIVE, false);
    }
}
