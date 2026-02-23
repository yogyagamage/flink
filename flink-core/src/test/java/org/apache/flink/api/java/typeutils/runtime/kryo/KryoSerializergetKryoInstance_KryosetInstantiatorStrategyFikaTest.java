package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class KryoSerializergetKryoInstance_KryosetInstantiatorStrategyFikaTest {

    @Test
    public void testGetKryoTriggersSetInstantiatorStrategy() throws Exception {
        // Create a simple type for the serializer
        Class<String> type = String.class;
        
        // Create a minimal SerializerConfig with empty configurations
        SerializerConfigImpl serializerConfig = new SerializerConfigImpl();
        
        // Create the KryoSerializer instance using the public constructor
        KryoSerializer<String> serializer = new KryoSerializer<>(type, serializerConfig);
        
        // Call the entry point method which should trigger the full chain
        // This will go through: getKryo() -> checkKryoInitialized() -> getKryoInstance()
        // In getKryoInstance(), when Chill classes are not found, it creates a new Kryo
        // and calls kryo.setInstantiatorStrategy()
        Kryo kryo = serializer.getKryo();
    }
}
