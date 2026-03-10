package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;

class EntrypointClusterConfigurationParserFactory_CommandLineOptionsmethod_BuilderargNameFikaTest {

    @Test
    void testCreateResultTriggersBuilderArgName() throws Exception {
        EntrypointClusterConfigurationParserFactory factory = 
            new EntrypointClusterConfigurationParserFactory();
        
        Options options = new Options();
        options.addOption(
            org.apache.flink.runtime.entrypoint.parser.CommandLineOptions.CONFIG_DIR_OPTION);
        options.addOption(
            org.apache.flink.runtime.entrypoint.parser.CommandLineOptions.DYNAMIC_PROPERTY_OPTION);
        
        CommandLine commandLine = new DefaultParser().parse(
            options, 
            new String[]{"-c", "test-config-dir", "-D", "key=value"}
        );
        
        factory.createResult(commandLine);
    }
}
