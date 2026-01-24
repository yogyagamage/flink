package org.apache.flink.api.java.typeutils.runtime;

import com.esotericsoftware.kryo.io.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class NoFetchingInputmethod_InputmethodFikaTest {

    @Test
    void testEntryPointCallsThirdPartyMethod() {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        NoFetchingInput noFetchingInput = new NoFetchingInput(inputStream);
    }
}
