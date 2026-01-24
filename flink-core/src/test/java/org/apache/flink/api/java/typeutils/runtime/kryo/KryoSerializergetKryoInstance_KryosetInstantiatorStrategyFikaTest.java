package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class KryoSerializergetKryoInstance_KryosetInstantiatorStrategyFikaTest {

    @Test
    public void testGetKryoTriggersSetInstantiatorStrategy() throws Exception {
        // Create empty configuration objects
        LinkedHashMap<Class<?>, SerializableSerializer<?>> defaultSerializers = new LinkedHashMap<>();
        LinkedHashMap<Class<?>, Class<? extends com.esotericsoftware.kryo.Serializer<?>>> defaultSerializerClasses = new LinkedHashMap<>();
        LinkedHashMap<String, KryoRegistration> kryoRegistrations = new LinkedHashMap<>();
        
        // Create a simple type class for the serializer
        Class<String> type = String.class;
        
        // Use the third constructor which accepts all required parameters
        KryoSerializer<String> serializer = new KryoSerializer<>(
            type,
            defaultSerializers,
            defaultSerializerClasses,
            kryoRegistrations
        );
        
        // This call should traverse through:
        // 1. getKryo()
        // 2. checkKryoInitialized()
        // 3. getKryoInstance()
        // 4. Kryo.setInstantiatorStrategy(...)
        Kryo kryo = serializer.getKryo();
    }
}
