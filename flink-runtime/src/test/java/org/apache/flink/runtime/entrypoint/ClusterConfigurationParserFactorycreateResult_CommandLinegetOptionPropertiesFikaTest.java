package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.runtime.entrypoint.parser.CommandLineOptions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClusterConfigurationParserFactorycreateResult_CommandLinegetOptionPropertiesFikaTest {

    @Test
    void testCreateResultInvokesGetOptionProperties() throws Exception {
        // Create the factory instance
        ClusterConfigurationParserFactory factory = new ClusterConfigurationParserFactory();
        
        // Create mock CommandLine
        CommandLine commandLine = mock(CommandLine.class);
        
        // Setup mocks for required option values
        when(commandLine.getOptionValue(CommandLineOptions.CONFIG_DIR_OPTION.getOpt()))
            .thenReturn("/tmp/config");
        
        // Create properties that will be returned by getOptionProperties
        Properties dynamicProperties = new Properties();
        dynamicProperties.setProperty("key", "value");
        
        // Setup the target third-party method call
        when(commandLine.getOptionProperties(CommandLineOptions.DYNAMIC_PROPERTY_OPTION.getOpt()))
            .thenReturn(dynamicProperties);
        
        // Setup for commandLine.getArgs()
        when(commandLine.getArgs()).thenReturn(new String[0]);
        
        // Execute the entry point method
        factory.createResult(commandLine);
    }
}
