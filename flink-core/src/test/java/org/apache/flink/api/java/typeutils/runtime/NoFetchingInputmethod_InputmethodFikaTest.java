package org.apache.flink.api.java.typeutils.runtime;

import com.esotericsoftware.kryo.io.Input;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

public class NoFetchingInputmethod_InputmethodFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        InputStream inputStream = new java.io.ByteArrayInputStream(new byte[0]);
        NoFetchingInput instance = new NoFetchingInput(inputStream);
    }
}
