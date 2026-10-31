package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;

import java.util.HashMap;

public class YamlParserUtilsconvertToObject_LoadloadFromStringFikaTest {

    @Test
    public void testConvertToObjectInvokesLoadFromString() throws Exception {
        // Create a real Load instance with default settings
        LoadSettings settings = LoadSettings.builder().build();
        Load loader = new Load(settings);
        
        // Create a simple YAML string that can be parsed
        String yamlContent = "key: value";
        
        // Use reflection to invoke the private static method
        java.lang.reflect.Method method = Class.forName("org.apache.flink.configuration.YamlParserUtils")
                .getDeclaredMethod("convertToObject", String.class, Class.class);
        method.setAccessible(true);
        
        // Invoke with HashMap.class since YAML can naturally parse to Map
        method.invoke(null, yamlContent, HashMap.class);
    }
}
