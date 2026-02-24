package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class JavaSerializerwrite_ObjectMapputFikaTest {

    @Test
    void testWriteTriggersObjectMapPut() throws Exception {
        Kryo kryo = new Kryo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        
        JavaSerializer<String> serializer = new JavaSerializer<>();
        
        // First call should trigger ObjectMap.put when creating ObjectOutputStream
        serializer.write(kryo, output, "test1");
        
        // Second call should use existing ObjectOutputStream from context
        serializer.write(kryo, output, "test2");
        
        // Clear context and call again to trigger put again
        kryo.getGraphContext().clear();
        serializer.write(kryo, output, "test3");
    }
}
