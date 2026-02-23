package org.apache.flink.api.java.typeutils.runtime;

import org.junit.jupiter.api.Test;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import org.apache.flink.types.Value;
import org.objenesis.strategy.StdInstantiatorStrategy;

class ValueSerializercheckKryoInitialized_DefaultInstantiatorStrategysetFallbackInstantiatorStrategyFikaTest {

    @Test
    void testCopyTriggersSetFallbackInstantiatorStrategy() throws Exception {
        ValueSerializer<TestValue> serializer = new ValueSerializer<>(TestValue.class);
        
        TestValue testValue = new TestValue();
        serializer.copy(testValue);
    }

    private static class TestValue implements Value {
        public void read(org.apache.flink.core.memory.DataInputView in) {
        }

        public void write(org.apache.flink.core.memory.DataOutputView out) {
        }
    }
}
