package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionmethodFikaTest4 {

    @TempDir
    private Path tempDir;

    @Test
    public void testLoadYamlFileTriggersYamlEngineException() throws Exception {
        // Create a malformed YAML file that will cause SnakeYAML to throw MarkedYamlEngineException
        File yamlFile = tempDir.resolve("invalid.yaml").toFile();
        
        try (FileOutputStream fos = new FileOutputStream(yamlFile)) {
            // Invalid YAML: duplicate key without proper structure
            String invalidYaml = "key1: value1\nkey1: value2\n: invalid";
            fos.write(invalidYaml.getBytes());
        }
        
        // This should trigger the call chain:
        // 1. loadYamlFile() tries to parse invalid YAML
        // 2. SnakeYAML throws MarkedYamlEngineException
        // 3. wrapExceptionToHiddenSensitiveData() is called
        // 4. YamlEngineException constructor is invoked
        try {
            YamlParserUtils.loadYamlFile(yamlFile);
        } catch (Exception e) {
            // Expected - we want the exception to be thrown to reach the target method
        }
    }
}
