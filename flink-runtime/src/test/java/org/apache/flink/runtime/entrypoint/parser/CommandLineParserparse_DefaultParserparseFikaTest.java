package org.apache.flink.runtime.entrypoint.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.flink.runtime.entrypoint.FlinkParseException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandLineParserparse_DefaultParserparseFikaTest {

    @Test
    void test() throws FlinkParseException {
        ParserResultFactory<Object> mockFactory = Mockito.mock(ParserResultFactory.class);
        Options options = new Options();
        options.addOption("test", "test option");
        Mockito.when(mockFactory.getOptions()).thenReturn(options);
        Mockito.when(mockFactory.createResult(Mockito.any(CommandLine.class))).thenReturn(new Object());
        
        CommandLineParser<Object> parser = new CommandLineParser<>(mockFactory);
        String[] args = {"--test"};
        parser.parse(args);
    }
}
