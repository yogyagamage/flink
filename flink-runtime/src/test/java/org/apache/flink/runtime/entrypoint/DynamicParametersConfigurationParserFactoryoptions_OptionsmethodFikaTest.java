package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.flink.runtime.entrypoint.parser.CommandLineOptions;
import org.junit.jupiter.api.Test;

class DynamicParametersConfigurationParserFactoryoptions_OptionsmethodFikaTest {

    @Test
    void testOptions() {
        DynamicParametersConfigurationParserFactory factory = new DynamicParametersConfigurationParserFactory();
        factory.options();
    }
}
