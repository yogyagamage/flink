package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.common.FlowStyle;

public class YamlParserUtilsmethod_DumpSettingsBuildersetDefaultFlowStyleFikaTest {

    @Test
    public void testConvertToObjectTriggersSetDefaultFlowStyle() {
        // This call will trigger static initialization of YamlParserUtils,
        // which includes DumpSettings.builder().setDefaultFlowStyle(FlowStyle.BLOCK)
        // and DumpSettings.builder().setDefaultFlowStyle(FlowStyle.FLOW)
        YamlParserUtils.convertToObject("key: value", java.util.Map.class);
    }
}
