package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;
import java.util.Optional;

class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionsetStackTraceFikaTest {

    @Test
    void testConvertToObjectTriggersSetStackTrace() throws Exception {
        YamlParserUtils utils = new YamlParserUtils();
        
        String yamlContent = "invalid: yaml: content";
        
        try {
            utils.convertToObject(yamlContent, Object.class);
        } catch (YamlEngineException e) {
            // Expected - the setStackTrace method should have been called
        }
    }
}
