package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.LoadSettings;

import java.util.Map;

class YamlParserUtilsmethod_LoadmethodFikaTest4 {

    @Test
    void testLoadConstructorInvocation() {
        // The static loader field in YamlParserUtils is initialized with
        // new Load(LoadSettings.builder().setSchema(new CoreSchema()).build())
        // which calls the target constructor.
        // We need to trigger class initialization to execute the static initializer.
        
        // Access a static field to trigger class loading and static initialization
        Class<?> clazz = YamlParserUtils.class;
        
        // Parse a simple YAML to ensure the loader is used
        String yamlContent = "key: value";
        Map<String, Object> result = YamlParserUtils.convertToObject(yamlContent, Map.class);
    }
}
