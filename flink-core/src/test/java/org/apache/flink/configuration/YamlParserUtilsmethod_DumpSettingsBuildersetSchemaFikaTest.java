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
        // DumpSettings.builder().setSchema(new CoreSchema())
        // This happens during static field initialization
        
        // Trigger class loading and static initialization
        Class<YamlParserUtils> clazz = YamlParserUtils.class;
        
        // Call the entry point method to ensure the full chain is executed
        // The third-party method setSchema is already called during static initialization
        // but we still need to call convertToObject to follow the specified path
        String yamlContent = "key: value";
        YamlParserUtils.convertToObject(yamlContent, Object.class);
    }
}
