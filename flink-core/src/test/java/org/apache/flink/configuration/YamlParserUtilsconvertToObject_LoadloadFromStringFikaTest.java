package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

public class YamlParserUtilsconvertToObject_LoadloadFromStringFikaTest {

    @Test
    public void testConvertToObjectInvokesLoadFromString() {
        // Create a valid YAML string
        String yamlContent = "key: value";
        
        // Call the entry point method which should invoke Load.loadFromString
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
