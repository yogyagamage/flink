package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

class YamlParserUtilsconvertToObject_LoadloadFromStringFikaTest {

    @Test
    void testConvertToObjectInvokesLoadFromString() {
        // The entry point is a static method, so no instance is needed
        // We need to call convertToObject with a valid YAML string and a target class
        // The method will internally call loader.loadFromString(value)
        // where loader is a static field initialized with LoadSettings and CoreSchema
        
        // Create a simple YAML string that can be parsed
        String yamlContent = "key: value";
        
        // Call the entry point method - this will trigger the chain to Load.loadFromString
        YamlParserUtils.convertToObject(yamlContent, java.util.Map.class);
    }
}
