package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class YamlParserUtilsloadYamlFile_LoadloadFromInputStreamFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testLoadYamlFile() throws Exception {
        File yamlFile = tempDir.resolve("test.yaml").toFile();
        
        try (FileOutputStream fos = new FileOutputStream(yamlFile)) {
            fos.write("key: value\n".getBytes());
        }
        
        Map<String, Object> result = YamlParserUtils.loadYamlFile(yamlFile);
    }
}
