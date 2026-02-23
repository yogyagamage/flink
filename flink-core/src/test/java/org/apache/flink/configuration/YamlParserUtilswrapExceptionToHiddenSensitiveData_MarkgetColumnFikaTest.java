package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.Mark;
import java.util.Optional;

class YamlParserUtilswrapExceptionToHiddenSensitiveData_MarkgetColumnFikaTest {

    @Test
    void testConvertToObjectTriggersMarkGetColumn() throws Exception {
        YamlParserUtils utils = new YamlParserUtils();
        
        String invalidYaml = "key1: value1\nkey1: value2";
        
        try {
            YamlParserUtils.convertToObject(invalidYaml, Object.class);
        } catch (Exception e) {
            // Expected - we want the exception to be thrown so the path is executed
        }
    }
}
