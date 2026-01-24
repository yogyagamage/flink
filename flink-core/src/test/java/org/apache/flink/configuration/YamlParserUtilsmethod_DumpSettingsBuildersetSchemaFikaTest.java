package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.common.FlowStyle;
import org.snakeyaml.engine.v2.schema.CoreSchema;

class YamlParserUtilsmethod_DumpSettingsBuildersetSchemaFikaTest {

    @Test
    void testConvertToObjectTriggersSetSchema() {
        // The static initializer of YamlParserUtils will be triggered
        // when we first access the class, which will invoke
        // DumpSettings.builder().setSchema(new CoreSchema()) twice
        // (once for blockerDumperSettings and once for flowDumperSettings)
        // This will call the target third-party method:
        // org.snakeyaml.engine.v2.api.DumpSettingsBuilder.setSchema(org.snakeyaml.engine.v2.schema.Schema)
        
        // Trigger static initialization by calling the entry point method
        String yamlContent = "key: value";
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
