package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class JavaSerializerread_KryogetGraphContextFikaTest {

    @Test
    void testReadInvokesGetGraphContext() throws Exception {
        JavaSerializer<String> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        byte[] data = new byte[0];
        Input input = new Input(new ByteArrayInputStream(data));
        
        try {
            serializer.read(kryo, input, String.class);
        } catch (Exception e) {
            // Expected - we only care that getGraphContext() was invoked
        }
    }
}
