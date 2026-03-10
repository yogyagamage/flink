package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.runtime.entrypoint.parser.ConfigurationCommandLineOptions;
import org.junit.jupiter.api.Test;

public class ModifiableClusterConfigurationParserFactory_ConfigurationCommandLineOptionsmethod_BuilderargNameFikaTest {

    @Test
    public void testOptionsMethodTriggersBuilderArgName() {
        ModifiableClusterConfigurationParserFactory factory = new ModifiableClusterConfigurationParserFactory();
        factory.options();
    }
}
