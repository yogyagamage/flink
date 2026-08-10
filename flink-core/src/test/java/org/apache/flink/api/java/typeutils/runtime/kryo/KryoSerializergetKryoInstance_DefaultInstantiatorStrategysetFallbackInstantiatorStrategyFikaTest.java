package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class KryoSerializergetKryoInstance_DefaultInstantiatorStrategysetFallbackInstantiatorStrategyFikaTest {

    @Test
    public void testGetKryoTriggersSetFallbackInstantiatorStrategy() throws Exception {
        Class<String> type = String.class;
        SerializerConfig serializerConfig = new SerializerConfigImpl();
        
        LinkedHashMap<Class<?>, SerializableSerializer<?>> defaultSerializers = new LinkedHashMap<>();
        LinkedHashMap<Class<?>, Class<? extends Serializer<?>>> defaultSerializerClasses = new LinkedHashMap<>();
        LinkedHashMap<String, KryoRegistration> kryoRegistrations = new LinkedHashMap<>();
        
        KryoSerializer<String> serializer = new KryoSerializer<>(
            type,
            defaultSerializers,
            defaultSerializerClasses,
            kryoRegistrations
        );
        
        serializer.getKryo();
    }
}
