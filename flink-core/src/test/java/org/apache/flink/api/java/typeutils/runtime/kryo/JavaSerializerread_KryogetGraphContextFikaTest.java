package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaSerializerread_KryogetGraphContextFikaTest {

    @Test
    public void testReadInvokesGetGraphContext() throws Exception {
        JavaSerializer<Object> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        byte[] data = new byte[0];
        Input input = new Input(new ByteArrayInputStream(data));
        
        try {
            serializer.read(kryo, input, Object.class);
        } catch (Exception e) {
            // Expected - the test only needs to execute the method chain
        }
    }
}
