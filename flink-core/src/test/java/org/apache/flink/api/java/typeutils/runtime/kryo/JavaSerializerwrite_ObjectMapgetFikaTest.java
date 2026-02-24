package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.Serializable;

class JavaSerializerwrite_ObjectMapgetFikaTest {

    @Test
    void testWriteInvokesObjectMapGet() throws Exception {
        JavaSerializer<Serializable> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        Output output = new Output(1024);
        Serializable testObject = "test";
        
        serializer.write(kryo, output, testObject);
    }
}
