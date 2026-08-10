package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ConfigurationUtils_YamlParserUtilsmethod_LoadmethodFikaTest {

    @Test
    void testConvertToListTriggersLoadConstructor() {
        // Trigger static initialization of YamlParserUtils which creates the Load instance
        Class<?> clazz = YamlParserUtils.class;
        
        // Call convertToList with parameters that will trigger the YamlParserUtils path
        Object rawValue = "- key1: value1\n- key2: value2";
        Class<?> atomicClass = Map.class;
        
        // This will trigger YamlParserUtils.convertToObject which uses the static loader field
        // The static loader field initialization calls: new Load(LoadSettings.builder().setSchema(new CoreSchema()).build())
        ConfigurationUtils.convertToList(rawValue, atomicClass);
    }
}
