package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

class YamlParserUtilsloadYamlFile_LoadloadFromInputStreamFikaTest {

    @Test
    void testLoadYamlFileCallsLoadFromInputStream() throws Exception {
        // Create a temporary YAML file with valid content
        File tempFile = File.createTempFile("test", ".yaml");
        tempFile.deleteOnExit();
        
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write("key: value\n".getBytes());
        }
        
        // The static method will internally call Load.loadFromInputStream
        Map<String, Object> result = YamlParserUtils.loadYamlFile(tempFile);
        
        // No assertions - test passes if loadFromInputStream is invoked without exception
    }
}
