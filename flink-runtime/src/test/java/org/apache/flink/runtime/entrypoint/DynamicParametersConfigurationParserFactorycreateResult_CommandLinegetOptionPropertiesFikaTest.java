package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;

class DynamicParametersConfigurationParserFactorycreateResult_CommandLinegetOptionPropertiesFikaTest {

    @Test
    void testCreateResultInvokesGetOptionProperties() throws Exception {
        DynamicParametersConfigurationParserFactory factory = new DynamicParametersConfigurationParserFactory();
        
        Options options = new Options();
        options.addOption("D", "dynamicproperty", true, "Dynamic property");
        
        CommandLine commandLine = new DefaultParser().parse(options, new String[]{"-D", "key=value"});
        
        factory.createResult(commandLine);
    }
}
