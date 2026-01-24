package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class YamlParserUtilsconvertAndDumpYamlFromFlatMap_DumpdumpToStringFikaTest {

    @Test
    public void testConvertAndDumpYamlFromFlatMapInvokesDumpToString() {
        Map<String, Object> flattenMap = new HashMap<>();
        flattenMap.put("test.key", "value");
        
        YamlParserUtils.convertAndDumpYamlFromFlatMap(flattenMap);
    }
}
