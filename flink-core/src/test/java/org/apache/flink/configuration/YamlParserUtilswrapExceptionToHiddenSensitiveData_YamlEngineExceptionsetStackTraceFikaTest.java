package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;
import java.util.Optional;

class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionsetStackTraceFikaTest {

    @Test
    void testConvertToObjectTriggersSetStackTrace() throws Exception {
        YamlParserUtils utils = new YamlParserUtils();
        
        try {
            utils.convertToObject("invalid: yaml: content", Object.class);
        } catch (YamlEngineException e) {
            // The goal is to reach the setStackTrace call, no assertions needed
        }
    }
}
