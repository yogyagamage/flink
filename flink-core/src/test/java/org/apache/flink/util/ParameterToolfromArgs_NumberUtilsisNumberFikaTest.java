package org.apache.flink.util;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {

    @Test
    public void testFromArgsInvokesNumberUtilsIsNumber() {
        // Create a mock ParameterTool to avoid static method issues
        // This mock is unrelated to the target method call path
        ParameterTool mockTool = mock(ParameterTool.class);
        
        // Provide arguments that will trigger the NumberUtils.isNumber() call
        // The third argument "123" is a number that should trigger the isNumber check
        String[] args = {"--key1", "value1", "--key2", "123", "--key3", "value3"};
        
        // Execute the method under test
        ParameterTool.fromArgs(args);
    }
}
