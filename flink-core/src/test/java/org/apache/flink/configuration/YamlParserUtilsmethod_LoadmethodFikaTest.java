package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

import static org.mockito.Mockito.mock;

public class YamlParserUtilsmethod_LoadmethodFikaTest {

    @Test
    public void testConvertToObjectTriggersLoadConstructor() {
        // The static initializer will be triggered when the class is loaded
        // We need to call the entry point method to ensure the full chain executes
        String yamlContent = "key: value";
        
        // The static loader field will be initialized when the class is loaded
        // which happens when we reference YamlParserUtils
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
