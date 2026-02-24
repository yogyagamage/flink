package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;

public class YamlParserUtilsmethod_LoadmethodFikaTest {

    @Test
    public void testConvertToObjectTriggersLoadConstructor() {
        // This test triggers the static initialization of YamlParserUtils
        // which creates the Load instance via its constructor
        YamlParserUtils.convertToObject("key: value", java.util.Map.class);
    }
}
