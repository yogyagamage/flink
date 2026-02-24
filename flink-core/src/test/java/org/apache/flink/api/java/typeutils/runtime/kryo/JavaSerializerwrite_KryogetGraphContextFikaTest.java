package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class JavaSerializerwrite_KryogetGraphContextFikaTest {

    @Test
    public void testWriteInvokesGetGraphContext() throws Exception {
        Kryo kryo = new Kryo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        JavaSerializer<String> serializer = new JavaSerializer<>();
        
        serializer.write(kryo, output, "test");
    }
}
