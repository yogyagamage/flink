package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Map;

public class YamlParserUtilsloadYamlFile_LoadloadFromInputStreamFikaTest {

    @Test
    public void testLoadYamlFile() throws Exception {
        // Create a temporary YAML file with valid content
        File tempFile = File.createTempFile("test", ".yaml");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write("key: value\n".getBytes());
        }
        
        // This will execute the method and reach Load.loadFromInputStream
        Map<String, Object> result = YamlParserUtils.loadYamlFile(tempFile);
        
        // Clean up
        tempFile.delete();
    }
}
