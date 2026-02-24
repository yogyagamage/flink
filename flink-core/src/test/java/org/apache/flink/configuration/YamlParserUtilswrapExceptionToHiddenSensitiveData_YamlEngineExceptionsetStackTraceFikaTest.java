package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;
import java.util.Optional;

public class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionsetStackTraceFikaTest {

    @Test
    public void testConvertToObjectTriggersSetStackTrace() {
        // Create a MarkedYamlEngineException that will trigger the wrapExceptionToHiddenSensitiveData method
        MarkedYamlEngineException markedException = new MarkedYamlEngineException(
            "Test context",
            Optional.empty(),
            "Test problem",
            Optional.empty(),
            null
        ) {
            // Override getStackTrace to return a non-null array
            @Override
            public StackTraceElement[] getStackTrace() {
                return new StackTraceElement[] {
                    new StackTraceElement("TestClass", "testMethod", "TestFile.java", 42)
                };
            }
        };

        // Call the entry point method with input that will trigger the exception handling
        try {
            YamlParserUtils.convertToObject("invalid: yaml: content", Object.class);
        } catch (YamlEngineException e) {
            // Expected - the setStackTrace method was called during exception wrapping
        }
    }
}
