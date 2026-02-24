package org.apache.flink.util;

import org.junit.jupiter.api.Test;

public class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {

    @Test
    public void testFromArgsInvokesNumberUtilsIsNumber() {
        // Create input that will cause NumberUtils.isNumber() to be called
        // The method checks if args[i] is a number when key starts with - or --
        // We need a key followed by a numeric string
        String[] args = {"--key1", "123"};
        
        // This will execute the full chain:
        // ParameterTool.fromArgs(args) -> NumberUtils.isNumber("123")
        ParameterTool.fromArgs(args);
    }
}
