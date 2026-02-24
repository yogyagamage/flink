package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class YamlParserUtilswrapExceptionToHiddenSensitiveData_MarkgetColumnFikaTest4 {

    @TempDir
    Path tempDir;

    @Test
    public void testLoadYamlFileTriggersMarkGetColumn() throws Exception {
        File yamlFile = tempDir.resolve("test.yaml").toFile();
        
        try (FileWriter writer = new FileWriter(yamlFile)) {
            writer.write("key1: value1\n");
            writer.write("key1: value2\n");
        }
        
        try {
            YamlParserUtils.loadYamlFile(yamlFile);
        } catch (Exception e) {
            // Expected - the duplicate key should trigger the exception path
        }
    }
}
