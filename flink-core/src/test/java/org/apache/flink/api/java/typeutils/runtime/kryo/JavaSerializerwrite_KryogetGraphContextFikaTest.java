package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class JavaSerializerwrite_KryogetGraphContextFikaTest {

    @Test
    void testWriteInvokesGetGraphContext() throws Exception {
        JavaSerializer<Object> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        
        serializer.write(kryo, output, "testObject");
    }
}
