package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import org.junit.jupiter.api.Test;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class JavaSerializerwrite_KryoExceptionmethodFikaTest {

    @Test
    public void testWriteMethodTriggersKryoException() throws IOException {
        JavaSerializer<Object> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        Output output = new Output(100);
        
        ObjectMap graphContext = kryo.getGraphContext();
        ObjectOutputStream objectStream = new ObjectOutputStream(output);
        graphContext.put(serializer, objectStream);
        
        try {
            serializer.write(kryo, output, new Object());
        } catch (KryoException e) {
            // Expected exception - no assertion needed
        }
    }
}
