package org.apache.flink.api.java.typeutils.runtime;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import org.apache.flink.types.Value;
import org.objenesis.strategy.StdInstantiatorStrategy;
import org.junit.jupiter.api.Test;

class ValueSerializercheckKryoInitialized_KryosetInstantiatorStrategyFikaTest {

    @Test
    void testCopyTriggersKryoSetInstantiatorStrategy() {
        ValueSerializer<TestValue> serializer = new ValueSerializer<>(TestValue.class);
        TestValue testValue = new TestValue();
        serializer.copy(testValue);
    }

    private static class TestValue implements Value {
        public void write(org.apache.flink.core.memory.DataOutputView out) {
        }

        public void read(org.apache.flink.core.memory.DataInputView in) {
        }
    }
}
