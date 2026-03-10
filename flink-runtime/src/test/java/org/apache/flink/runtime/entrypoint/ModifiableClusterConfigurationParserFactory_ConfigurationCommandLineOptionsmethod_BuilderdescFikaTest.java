package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Option.Builder;
import org.apache.commons.cli.Options;
import org.apache.flink.runtime.entrypoint.parser.CommandLineOptions;
import org.apache.flink.runtime.entrypoint.parser.ConfigurationCommandLineOptions;
import org.junit.jupiter.api.Test;

public class ModifiableClusterConfigurationParserFactory_ConfigurationCommandLineOptionsmethod_BuilderdescFikaTest {

    @Test
    public void testOptionsMethodTriggersBuilderDesc() {
        ModifiableClusterConfigurationParserFactory factory = new ModifiableClusterConfigurationParserFactory();
        factory.options();
    }
}
