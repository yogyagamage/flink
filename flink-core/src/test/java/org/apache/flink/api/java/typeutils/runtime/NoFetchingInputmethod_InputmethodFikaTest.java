package org.apache.flink.api.java.typeutils.runtime;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import static org.mockito.Mockito.mock;

public class NoFetchingInputmethod_InputmethodFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        InputStream mockInputStream = mock(InputStream.class);
        new NoFetchingInput(mockInputStream);
    }
}
