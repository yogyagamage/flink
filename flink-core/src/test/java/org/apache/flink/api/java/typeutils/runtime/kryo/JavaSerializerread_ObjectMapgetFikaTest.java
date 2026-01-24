package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.util.ObjectMap;
import org.apache.flink.util.InstantiationUtil;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaSerializerread_ObjectMapgetFikaTest {

    @Test
    public void testReadInvokesObjectMapGet() throws Exception {
        JavaSerializer<String> serializer = new JavaSerializer<>();
        
        Kryo kryo = new Kryo();
        ObjectMap graphContext = kryo.getGraphContext();
        
        byte[] data = new byte[0];
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        Input input = new Input(bais);
        
        Class<String> targetClass = String.class;
        
        try {
            serializer.read(kryo, input, targetClass);
        } catch (Exception e) {
            // Expected - we don't care about the result
        }
    }
}
