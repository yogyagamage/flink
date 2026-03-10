package org.apache.flink.runtime.clusterframework;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.DefaultParser;
import org.apache.flink.configuration.Configuration;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class BootstrapToolsparseDynamicProperties_CommandLinegetOptionValuesFikaTest {

    @Test
    public void testParseDynamicProperties() throws Exception {
        // Create a CommandLine instance with the DYNAMIC_PROPERTIES_OPT option
        Options options = new Options();
        
        // Use reflection to access the private static field DYNAMIC_PROPERTIES_OPT
        Field dynamicPropertiesField = BootstrapTools.class.getDeclaredField("DYNAMIC_PROPERTIES_OPT");
        dynamicPropertiesField.setAccessible(true);
        String dynamicPropertyOpt = (String) dynamicPropertiesField.get(null);
        
        Option dynamicOption = Option.builder(dynamicPropertyOpt)
                .hasArgs()
                .valueSeparator('=')
                .build();
        options.addOption(dynamicOption);
        
        // Create command line arguments with dynamic properties
        String[] args = {"-D", "key1=value1", "-D", "key2=value2"};
        
        // Parse the command line
        DefaultParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        
        // Call the entry point method - this should trigger the third-party method call
        BootstrapTools.parseDynamicProperties(cmd);
    }
}
