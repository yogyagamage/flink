package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.runtime.entrypoint.parser.CommandLineOptions;
import org.apache.flink.runtime.entrypoint.parser.ConfigurationCommandLineOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class ModifiableClusterConfigurationParserFactorycreateResult_CommandLinegetOptionValueFikaTest {

    @Test
    void testCreateResultInvokesGetOptionValue() throws Exception {
        ModifiableClusterConfigurationParserFactory factory = new ModifiableClusterConfigurationParserFactory();
        
        Options options = new Options();
        Option configDirOption = Option.builder("c")
                .longOpt("configDir")
                .hasArg()
                .build();
        options.addOption(configDirOption);
        
        CommandLine commandLine = new org.apache.commons.cli.DefaultParser().parse(options, new String[]{"-c", "/tmp/config"});
        
        factory.createResult(commandLine);
    }
}
