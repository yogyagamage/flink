package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.apache.flink.util.CollectionUtil;
import org.apache.flink.util.TernaryBoolean;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class KryoSerializercheckKryoInitialized_KryosetClassLoaderFikaTest {

    @Test
    void testGetKryoTriggersSetClassLoader() {
        // Create required constructor parameters
        Class<String> type = String.class;
        SerializerConfig serializerConfig = new SerializerConfigImpl();
        
        // Build defaultSerializers map
        LinkedHashMap<Class<?>, SerializableSerializer<?>> defaultSerializers = 
            CollectionUtil.newLinkedHashMapWithExpectedSize(0);
        
        // Build defaultSerializerClasses map
        LinkedHashMap<Class<?>, Class<? extends Serializer<?>>> defaultSerializerClasses = 
            CollectionUtil.newLinkedHashMapWithExpectedSize(0);
        
        // Build kryoRegistrations map
        LinkedHashMap<String, KryoRegistration> kryoRegistrations = 
            CollectionUtil.newLinkedHashMapWithExpectedSize(0);
        
        // Build legacy fields for backward compatibility
        LinkedHashSet<Class<?>> registeredTypes = new LinkedHashSet<>();
        LinkedHashMap<Class<?>, Class<? extends Serializer<?>>> registeredTypesWithSerializerClasses = 
            CollectionUtil.newLinkedHashMapWithExpectedSize(0);
        LinkedHashMap<Class<?>, SerializableSerializer<?>> registeredTypesWithSerializers = 
            CollectionUtil.newLinkedHashMapWithExpectedSize(0);
        
        // Create KryoSerializer instance using the third constructor
        KryoSerializer<String> serializer = new KryoSerializer<>(
            type,
            defaultSerializers,
            defaultSerializerClasses,
            kryoRegistrations
        );
        
        // Set legacy fields via reflection to ensure proper initialization
        try {
            java.lang.reflect.Field registeredTypesField = 
                KryoSerializer.class.getDeclaredField("registeredTypes");
            registeredTypesField.setAccessible(true);
            registeredTypesField.set(serializer, registeredTypes);
            
            java.lang.reflect.Field registeredTypesWithSerializerClassesField = 
                KryoSerializer.class.getDeclaredField("registeredTypesWithSerializerClasses");
            registeredTypesWithSerializerClassesField.setAccessible(true);
            registeredTypesWithSerializerClassesField.set(serializer, registeredTypesWithSerializerClasses);
            
            java.lang.reflect.Field registeredTypesWithSerializersField = 
                KryoSerializer.class.getDeclaredField("registeredTypesWithSerializers");
            registeredTypesWithSerializersField.setAccessible(true);
            registeredTypesWithSerializersField.set(serializer, registeredTypesWithSerializers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // Call the entry point method which should trigger the third-party method
        serializer.getKryo();
    }
}
