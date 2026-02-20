package org.apache.flink.util;

import org.junit.jupiter.api.Test;

public class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {
    
    @Test
    public void testFromArgsInvokesNumberUtilsIsNumber() {
        String[] args = {"--key", "123"};
        ParameterTool.fromArgs(args);
    }
}
