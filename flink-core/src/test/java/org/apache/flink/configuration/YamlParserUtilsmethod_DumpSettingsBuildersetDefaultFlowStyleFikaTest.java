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
        // The static initializer will be triggered when the class is loaded
        // We need to trigger it explicitly by calling a static method
        YamlParserUtils.convertToObject("key: value", java.util.Map.class);
    }
}
