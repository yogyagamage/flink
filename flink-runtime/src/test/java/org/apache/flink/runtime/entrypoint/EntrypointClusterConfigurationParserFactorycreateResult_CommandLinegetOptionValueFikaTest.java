package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.flink.runtime.entrypoint.parser.CommandLineOptions;
import org.junit.jupiter.api.Test;

class EntrypointClusterConfigurationParserFactorycreateResult_CommandLinegetOptionValueFikaTest {

    @Test
    void testCreateResult() throws Exception {
        Options options = new Options();
        options.addOption(CommandLineOptions.CONFIG_DIR_OPTION);
        options.addOption(CommandLineOptions.DYNAMIC_PROPERTY_OPTION);
        
        CommandLine commandLine = new DefaultParser().parse(options, new String[]{"--configDir", "/tmp"});
        
        EntrypointClusterConfigurationParserFactory factory = new EntrypointClusterConfigurationParserFactory();
        factory.createResult(commandLine);
    }
}
