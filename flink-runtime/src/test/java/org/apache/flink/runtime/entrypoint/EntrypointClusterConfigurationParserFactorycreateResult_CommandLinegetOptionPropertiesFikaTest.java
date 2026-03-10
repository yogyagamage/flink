package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EntrypointClusterConfigurationParserFactorycreateResult_CommandLinegetOptionPropertiesFikaTest {

    @Test
    void testCreateResultInvokesGetOptionProperties() {
        EntrypointClusterConfigurationParserFactory factory = new EntrypointClusterConfigurationParserFactory();
        
        CommandLine commandLine = mock(CommandLine.class);
        Option configDirOption = mock(Option.class);
        Option dynamicPropertyOption = mock(Option.class);
        
        when(configDirOption.getOpt()).thenReturn("configDir");
        when(dynamicPropertyOption.getOpt()).thenReturn("D");
        
        when(commandLine.getOptionValue("configDir")).thenReturn("/tmp/config");
        when(commandLine.getOptionProperties("D")).thenReturn(new Properties());
        when(commandLine.getArgs()).thenReturn(new String[0]);
        
        factory.createResult(commandLine);
    }
}
