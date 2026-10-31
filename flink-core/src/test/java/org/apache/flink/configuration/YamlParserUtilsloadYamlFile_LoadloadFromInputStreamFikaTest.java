package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public class YamlParserUtilsloadYamlFile_LoadloadFromInputStreamFikaTest {
    
    @Test
    public void testLoadYamlFile() throws Exception {
        // Create a temporary YAML file with valid content
        File tempFile = createTempYamlFile();
        
        // This will execute the method and reach Load.loadFromInputStream
        Map<String, Object> result = YamlParserUtils.loadYamlFile(tempFile);
    }
    
    private File createTempYamlFile() throws Exception {
        File tempFile = File.createTempFile("test", ".yaml");
        tempFile.deleteOnExit();
        
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            String yamlContent = "key: value\nanother: 123";
            fos.write(yamlContent.getBytes());
        }
        
        return tempFile;
    }
}
