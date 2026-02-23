package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.common.FlowStyle;
import org.snakeyaml.engine.v2.schema.CoreSchema;

public class YamlParserUtilsmethod_DumpSettingsBuildersetDefaultFlowStyleFikaTest {

    @Test
    public void testConvertToObjectTriggersSetDefaultFlowStyle() {
        // The static initializer of YamlParserUtils will be triggered when the class is loaded
        // This happens when we reference the class or call its static method
        // We need to call convertToObject to ensure the full chain executes
        
        // Create a simple YAML string that can be parsed
        String yamlContent = "key: value";
        
        // Call the entry point method
        // This will trigger class loading and static initializer execution
        // which includes DumpSettings.builder().setDefaultFlowStyle(FlowStyle.BLOCK)
        YamlParserUtils.convertToObject(yamlContent, java.util.Map.class);
    }
}
