package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class YamlParserUtilsloadYamlFile_LoadloadFromInputStreamFikaTest {
    
    @Test
    public void testLoadYamlFileInvokesLoadFromInputStream(@TempDir File tempDir) throws Exception {
        File yamlFile = new File(tempDir, "test.yaml");
        
        try (FileOutputStream fos = new FileOutputStream(yamlFile)) {
            fos.write("key: value\n".getBytes());
        }
        
        Map<String, Object> result = YamlParserUtils.loadYamlFile(yamlFile);
    }
}
