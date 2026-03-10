package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.configuration.Configuration;
import org.junit.jupiter.api.Test;

class DynamicParametersConfigurationParserFactorycreateResult_OptiongetOptFikaTest {

    @Test
    void testCreateResult() throws Exception {
        DynamicParametersConfigurationParserFactory factory = 
            new DynamicParametersConfigurationParserFactory();
        
        Options options = new Options();
        Option dynamicOption = Option.builder("D")
            .hasArgs()
            .valueSeparator()
            .build();
        options.addOption(dynamicOption);
        
        String[] args = {"-D", "key=value"};
        CommandLine commandLine = new DefaultParser().parse(options, args);
        
        factory.createResult(commandLine);
    }
}
