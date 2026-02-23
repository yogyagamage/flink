package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

class YamlParserUtilsmethod_LoadmethodFikaTest {

    @Test
    void testConvertToObjectTriggersLoadConstructor() {
        // The static initializer will be triggered when the class is loaded
        // We need to call the entry point method to ensure the full chain executes
        String yamlContent = "key: value";
        
        // The static loader field initialization will call Load constructor
        // We call convertToObject which uses the loader
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
