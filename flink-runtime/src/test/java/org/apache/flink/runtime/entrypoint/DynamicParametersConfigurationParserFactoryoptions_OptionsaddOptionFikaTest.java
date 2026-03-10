package org.apache.flink.runtime.entrypoint;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;

class DynamicParametersConfigurationParserFactoryoptions_OptionsaddOptionFikaTest {

    @Test
    void testOptions() {
        DynamicParametersConfigurationParserFactory factory = new DynamicParametersConfigurationParserFactory();
        Options options = DynamicParametersConfigurationParserFactory.options();
    }
}
