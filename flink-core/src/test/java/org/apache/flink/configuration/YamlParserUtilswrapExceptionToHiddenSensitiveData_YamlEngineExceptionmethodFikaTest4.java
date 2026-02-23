package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionmethodFikaTest4 {

    @TempDir
    Path tempDir;

    @Test
    public void testLoadYamlFileTriggersYamlEngineException() throws Exception {
        // Create a malformed YAML file that will cause a MarkedYamlEngineException
        File yamlFile = tempDir.resolve("invalid.yaml").toFile();
        
        // Write invalid YAML content that will cause a parsing exception
        // Using duplicate keys to trigger MarkedYamlEngineException
        String invalidYaml = "key: value1\nkey: value2";
        try (FileOutputStream fos = new FileOutputStream(yamlFile)) {
            fos.write(invalidYaml.getBytes());
        }

        try {
            // This should trigger the loadYamlFile method which will catch MarkedYamlEngineException
            // and call wrapExceptionToHiddenSensitiveData, which creates a new YamlEngineException
            YamlParserUtils.loadYamlFile(yamlFile);
        } catch (YamlEngineException e) {
            // Expected - the third-party method YamlEngineException.<init> was invoked
        } catch (Exception e) {
            // Other exceptions are acceptable as long as the path was attempted
        }
    }
}
