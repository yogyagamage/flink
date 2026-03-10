package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.api.java.tuple.Tuple3;
import org.junit.jupiter.api.Test;

public class ModifiableClusterConfigurationParserFactorycreateResult_CommandLinehasOptionFikaTest {

    @Test
    public void testCreateResultInvokesCommandLineHasOption() throws Exception {
        Options options = new Options();
        
        Option configDirOption = Option.builder("c")
                .longOpt("configDir")
                .hasArg()
                .build();
        options.addOption(configDirOption);
        
        Option dynamicPropertyOption = Option.builder("D")
                .hasArgs()
                .valueSeparator()
                .build();
        options.addOption(dynamicPropertyOption);
        
        Option removeKeyOption = Option.builder("r")
                .longOpt("removeKey")
                .hasArgs()
                .build();
        options.addOption(removeKeyOption);
        
        Option removeKeyValueOption = Option.builder("R")
                .longOpt("removeKeyValue")
                .hasArgs()
                .valueSeparator()
                .build();
        options.addOption(removeKeyValueOption);
        
        Option replaceKeyValueOption = Option.builder("t")
                .longOpt("replaceKeyValue")
                .hasArgs()
                .build();
        options.addOption(replaceKeyValueOption);
        
        Option flattenOption = Option.builder("f")
                .longOpt("flatten")
                .build();
        options.addOption(flattenOption);
        
        String[] args = {
            "-c", "/tmp/config",
            "-D", "key1=value1",
            "-r", "remove1", "remove2",
            "-R", "removeKey1=removeValue1",
            "-t", "oldKey1", "newKey1", "newValue1",
            "-f"
        };
        
        DefaultParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);
        
        ModifiableClusterConfigurationParserFactory factory = 
            new ModifiableClusterConfigurationParserFactory();
        
        factory.createResult(commandLine);
    }
}
