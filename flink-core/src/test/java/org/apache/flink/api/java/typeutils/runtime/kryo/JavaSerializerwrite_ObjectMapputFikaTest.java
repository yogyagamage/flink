package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class JavaSerializerwrite_ObjectMapputFikaTest {

    @Test
    public void testWriteTriggersObjectMapPut() throws Exception {
        JavaSerializer<String> serializer = new JavaSerializer<>();
        Kryo kryo = new Kryo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        
        kryo.getGraphContext().put(serializer, null);
        
        serializer.write(kryo, output, "test");
    }
}
