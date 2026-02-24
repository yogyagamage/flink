package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

public class YamlParserUtilsmethod_DumpSettingsBuildersetSchemaFikaTest {

    @Test
    public void testConvertToObjectTriggersSetSchema() {
        // This triggers static initialization which calls DumpSettings.builder().setSchema()
        YamlParserUtils.convertToObject("key: value", java.util.Map.class);
    }
}
