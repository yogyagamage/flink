package org.apache.flink.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.flink.configuration.Configuration;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {

    @Test
    public void testFromArgsInvokesNumberUtilsIsNumber() {
        // Create arguments that will cause NumberUtils.isNumber() to be called
        String[] args = {"--key", "123"};
        
        // Directly call the static entry point method
        ParameterTool.fromArgs(args);
    }
}
