package org.apache.flink.api.java.typeutils.runtime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.api.common.typeutils.base.IntSerializer;
import org.junit.jupiter.api.Test;

public class KryoUtilscopy_KryocopyFikaTest2 {

    @Test
    public void testCopyPath() {
        Kryo kryo = new Kryo();
        TypeSerializer<Integer> serializer = IntSerializer.INSTANCE;
        Integer original = 42;
        
        KryoUtils.copy(original, kryo, serializer);
    }
}
