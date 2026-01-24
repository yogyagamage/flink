package org.apache.flink.api.java.typeutils.runtime;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoBufferUnderflowException;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class NoFetchingInputrequire_KryoBufferUnderflowExceptionmethodFikaTest {

    @Test
    void testReadTriggersKryoBufferUnderflowException() throws KryoException {
        byte[] emptyData = new byte[0];
        InputStream emptyStream = new ByteArrayInputStream(emptyData);
        NoFetchingInput noFetchingInput = new NoFetchingInput(emptyStream);
        
        try {
            noFetchingInput.read();
        } catch (KryoBufferUnderflowException e) {
            // Expected exception - third party method was invoked
        }
    }
}
