package org.apache.flink.api.java.typeutils.runtime;

import org.junit.jupiter.api.Test;
import com.esotericsoftware.kryo.Kryo;
import org.apache.flink.types.Value;
import org.apache.flink.types.IntValue;

class ValueComparatorcheckKryoInitialized_KryosetInstantiatorStrategyFikaTest {

    @Test
    void testSetReferenceTriggersKryoSetInstantiatorStrategy() {
        ValueComparator<IntValue> comparator = new ValueComparator<>(true, IntValue.class);
        IntValue value = new IntValue(42);
        comparator.setReference(value);
    }
}
