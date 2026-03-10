package org.apache.flink.runtime.entrypoint.parser;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandLineParserprintHelp_HelpFormatterprintHelpFikaTest {

    @Test
    void testPrintHelp() {
        ParserResultFactory<Object> mockParserResultFactory = Mockito.mock(ParserResultFactory.class);
        Options mockOptions = Mockito.mock(Options.class);
        Mockito.when(mockParserResultFactory.getOptions()).thenReturn(mockOptions);
        
        CommandLineParser<Object> parser = new CommandLineParser<>(mockParserResultFactory);
        parser.printHelp("testSyntax");
    }
}
