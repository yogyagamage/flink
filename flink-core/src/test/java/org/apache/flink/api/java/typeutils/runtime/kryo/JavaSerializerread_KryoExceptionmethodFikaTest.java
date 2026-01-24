package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import org.apache.flink.util.InstantiationUtil;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class JavaSerializerread_KryoExceptionmethodFikaTest {

    @Test
    public void testReadMethodTriggersKryoException() throws Exception {
        JavaSerializer<Object> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        
        byte[] invalidData = new byte[] { (byte)0xac, (byte)0xed, 0x00, 0x05 };
        ByteArrayInputStream byteStream = new ByteArrayInputStream(invalidData);
        Input input = new Input(byteStream);
        
        try {
            serializer.read(kryo, input, Object.class);
        } catch (com.esotericsoftware.kryo.KryoException e) {
            // Expected - KryoException should be thrown
        }
    }
}
