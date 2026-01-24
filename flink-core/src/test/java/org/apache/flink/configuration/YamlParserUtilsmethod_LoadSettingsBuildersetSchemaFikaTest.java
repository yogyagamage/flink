package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.LoadSettingsBuilder;
import org.snakeyaml.engine.v2.schema.CoreSchema;

class YamlParserUtilsmethod_LoadSettingsBuildersetSchemaFikaTest {

    @Test
    void testConvertToObject() {
        YamlParserUtils.convertToObject("key: value", Object.class);
    }
}
