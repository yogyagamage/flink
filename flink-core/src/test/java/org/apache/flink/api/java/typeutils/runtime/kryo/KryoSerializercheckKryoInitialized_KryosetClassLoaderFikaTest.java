package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class KryoSerializercheckKryoInitialized_KryosetClassLoaderFikaTest {

    @Test
    public void testGetKryoTriggersSetClassLoader() {
        // Create empty collections for constructor parameters
        LinkedHashMap<Class<?>, SerializableSerializer<?>> defaultSerializers = new LinkedHashMap<>();
        LinkedHashMap<Class<?>, Class<? extends Serializer<?>>> defaultSerializerClasses = new LinkedHashMap<>();
        LinkedHashMap<String, KryoRegistration> kryoRegistrations = new LinkedHashMap<>();
        
        // Use the third constructor that accepts all required parameters
        KryoSerializer<String> serializer = new KryoSerializer<>(
            String.class,
            defaultSerializers,
            defaultSerializerClasses,
            kryoRegistrations
        );
        
        // Call the entry point method which should trigger the chain:
        // getKryo() -> checkKryoInitialized() -> Kryo.setClassLoader()
        serializer.getKryo();
    }
}
