package org.apache.flink.util;

import org.junit.jupiter.api.Test;

class ParameterToolfromArgs_NumberUtilsisNumberFikaTest {

    @Test
    void testFromArgsWithNumber() {
        String[] args = {"--key", "123"};
        ParameterTool.fromArgs(args);
    }
}
