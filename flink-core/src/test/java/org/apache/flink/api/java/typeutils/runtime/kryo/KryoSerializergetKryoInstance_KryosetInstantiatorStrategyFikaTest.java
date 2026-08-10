package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.apache.flink.util.CollectionUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;

public class KryoSerializergetKryoInstance_KryosetInstantiatorStrategyFikaTest {

    @Test
    public void testCreateInstanceTriggersKryoSetInstantiatorStrategy() throws Exception {
        // Create a concrete class type (not abstract, not interface)
        Class<String> concreteType = String.class;
        
        // Create minimal SerializerConfig with empty configurations
        SerializerConfigImpl serializerConfig = new SerializerConfigImpl();
        
        // Create KryoSerializer instance using the public constructor
        KryoSerializer<String> serializer = new KryoSerializer<>(concreteType, serializerConfig);
        
        // Call the entry point method
        serializer.createInstance();
    }
}
