package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlParserUtilsconvertAndDumpYamlFromFlatMap_DumpdumpToStringFikaTest {
    
    @Test
    public void testConvertAndDumpYamlFromFlatMap() {
        Map<String, Object> flattenMap = new LinkedHashMap<>();
        flattenMap.put("test.key", "value");
        
        YamlParserUtils.convertAndDumpYamlFromFlatMap(flattenMap);
    }
}
