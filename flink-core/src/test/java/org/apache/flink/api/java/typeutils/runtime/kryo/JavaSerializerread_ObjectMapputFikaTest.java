package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaSerializerread_ObjectMapputFikaTest {

    @Test
    public void testReadInvokesObjectMapPut() throws Exception {
        JavaSerializer<Object> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        
        byte[] data = new byte[] { -84, -19, 0, 5, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127, -121, 56, 2, 0, 1, 73, 0, 5, 118, 97, 108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 0, 0, 42 };
        Input input = new Input(new ByteArrayInputStream(data));
        
        kryo.getGraphContext().put(serializer, null);
        
        serializer.read(kryo, input, Object.class);
    }
}
