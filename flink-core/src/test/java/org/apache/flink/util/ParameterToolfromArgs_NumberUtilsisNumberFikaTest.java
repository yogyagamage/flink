package org.apache.flink.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.math.NumberUtils;

public class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {

    @Test
    public void testFromArgsInvokesNumberUtilsIsNumber() {
        // Create input that will cause NumberUtils.isNumber() to be called
        String[] args = {"--key", "123"};
        
        // Execute the entry point method which should invoke NumberUtils.isNumber()
        ParameterTool.fromArgs(args);
    }
}
