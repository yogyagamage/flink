package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.minlog.Log;
import org.apache.flink.api.common.SerializableSerializer;
import org.apache.flink.api.common.serialization.SerializerConfig;
import org.apache.flink.api.common.serialization.SerializerConfigImpl;
import org.apache.flink.api.java.typeutils.runtime.KryoRegistration;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

public class KryoSerializerconfigureKryoLogging_LogsetLoggerFikaTest3 {

    @Test
    public void testCopyTriggersConfigureKryoLogging() throws Exception {
        // Force TRACE logging to ensure configureKryoLogging() calls Log.setLogger()
        Logger logger = LoggerFactory.getLogger(KryoSerializer.class);
        java.lang.reflect.Field logField = KryoSerializer.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        
        // Create a spy logger that returns true for isTraceEnabled()
        org.slf4j.Logger spyLogger = org.mockito.Mockito.spy(logger);
        org.mockito.Mockito.when(spyLogger.isTraceEnabled()).thenReturn(true);
        
        // Replace the static LOG field with our spy
        org.mockito.Mockito.mockStatic(LoggerFactory.class).when(() -> 
            LoggerFactory.getLogger(KryoSerializer.class)
        ).thenReturn(spyLogger);
        
        // Re-initialize static fields that depend on LOG
        java.lang.reflect.Field concurrentAccessCheckField = 
            KryoSerializer.class.getDeclaredField("CONCURRENT_ACCESS_CHECK");
        concurrentAccessCheckField.setAccessible(true);
        
        // Trigger static initializer by creating an instance
        SerializerConfig config = new SerializerConfigImpl();
        KryoSerializer<String> serializer = new KryoSerializer<>(
            String.class,
            config
        );
        
        // Call the entry point method
        serializer.copy("test");
    }
}
