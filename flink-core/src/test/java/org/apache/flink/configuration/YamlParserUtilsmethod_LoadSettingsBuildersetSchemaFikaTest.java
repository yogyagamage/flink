package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.LoadSettingsBuilder;
import org.snakeyaml.engine.v2.schema.CoreSchema;

public class YamlParserUtilsmethod_LoadSettingsBuildersetSchemaFikaTest {

    @Test
    public void testConvertToObjectTriggersSetSchema() {
        // This call will trigger the static initializer which creates LoadSettingsBuilder
        // and calls setSchema on it
        YamlParserUtils.convertToObject("key: value", java.util.Map.class);
    }
}
