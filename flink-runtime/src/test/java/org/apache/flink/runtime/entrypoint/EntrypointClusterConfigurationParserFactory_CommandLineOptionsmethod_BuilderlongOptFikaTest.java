package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;

class EntrypointClusterConfigurationParserFactory_CommandLineOptionsmethod_BuilderlongOptFikaTest {

    @Test
    void testCreateResultTriggersBuilderLongOpt() throws Exception {
        EntrypointClusterConfigurationParserFactory factory = new EntrypointClusterConfigurationParserFactory();
        
        Options options = new Options();
        options.addOption("c", "configDir", true, "configuration directory");
        options.addOption("D", true, "use value for given property");
        
        CommandLine commandLine = new DefaultParser().parse(options, new String[] {
            "-c", "/tmp/config",
            "-D", "key=value"
        });
        
        factory.createResult(commandLine);
    }
}
