package org.apache.flink.runtime.entrypoint.parser;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CommandLineParserprintHelp_HelpFormattersetWidthFikaTest {

    @Test
    public void test() {
        ParserResultFactory<Object> mockFactory = Mockito.mock(ParserResultFactory.class);
        Mockito.when(mockFactory.getOptions()).thenReturn(new Options());
        
        CommandLineParser<Object> parser = new CommandLineParser<>(mockFactory);
        parser.printHelp("testSyntax");
    }
}
