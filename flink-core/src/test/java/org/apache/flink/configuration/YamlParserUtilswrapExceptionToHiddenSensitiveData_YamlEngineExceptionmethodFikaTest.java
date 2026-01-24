package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.MarkedYamlEngineException;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;
import org.snakeyaml.engine.v2.api.Dump;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.representer.BaseRepresenter;
import org.snakeyaml.engine.v2.schema.CoreSchema;
import org.snakeyaml.engine.v2.nodes.Tag;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.exceptions.Mark;
import org.snakeyaml.engine.v2.api.RepresentToNode;

import java.util.Optional;

public class YamlParserUtilswrapExceptionToHiddenSensitiveData_YamlEngineExceptionmethodFikaTest {

    @Test
    public void testConvertToObjectTriggersYamlEngineException() throws Exception {
        YamlParserUtils utils = new YamlParserUtils();
        
        String invalidYaml = "key: value\nkey: duplicate";
        
        try {
            utils.convertToObject(invalidYaml, Object.class);
        } catch (YamlEngineException e) {
            // Expected - third-party method was invoked
        }
    }
}
