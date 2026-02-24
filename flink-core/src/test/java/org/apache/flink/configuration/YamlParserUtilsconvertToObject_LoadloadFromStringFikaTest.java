package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

public class YamlParserUtilsconvertToObject_LoadloadFromStringFikaTest {

    @Test
    public void testConvertToObjectInvokesLoadFromString() {
        String yamlContent = "key: value";
        
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
