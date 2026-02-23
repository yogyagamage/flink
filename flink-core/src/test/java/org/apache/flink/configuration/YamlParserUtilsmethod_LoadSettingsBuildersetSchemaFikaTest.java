package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.LoadSettingsBuilder;
import org.snakeyaml.engine.v2.schema.CoreSchema;

public class YamlParserUtilsmethod_LoadSettingsBuildersetSchemaFikaTest {

    @Test
    public void testConvertToObjectTriggersSetSchema() {
        String yamlContent = "key: value";
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
