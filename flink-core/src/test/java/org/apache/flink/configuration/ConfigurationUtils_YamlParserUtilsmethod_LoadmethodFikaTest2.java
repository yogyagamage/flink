package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.LoadSettings;

import java.util.Map;

class ConfigurationUtils_YamlParserUtilsmethod_LoadmethodFikaTest2 {

    @Test
    void testLoadConstructorInvocation() {
        // Create LoadSettings to pass to Load constructor
        LoadSettings loadSettings = LoadSettings.builder()
                .setSchema(new org.snakeyaml.engine.v2.schema.CoreSchema())
                .build();
        
        // Directly instantiate Load to trigger the target third-party method
        org.snakeyaml.engine.v2.api.Load load = 
            new org.snakeyaml.engine.v2.api.Load(loadSettings);
        
        // Use the loader to ensure it's not optimized away
        String yamlContent = "key: value";
        Map<?, ?> parsed = (Map<?, ?>) load.loadFromString(yamlContent);
        
        // Also trigger the static loader in YamlParserUtils through reflection
        // to ensure the static initializer runs
        Class<?> clazz = YamlParserUtils.class;
        try {
            // Access a static field to trigger class initialization
            java.lang.reflect.Field loaderField = clazz.getDeclaredField("loader");
            loaderField.setAccessible(true);
            Object staticLoader = loaderField.get(null);
        } catch (Exception e) {
            // Ignore exceptions - we just want to trigger initialization
        }
    }
}
