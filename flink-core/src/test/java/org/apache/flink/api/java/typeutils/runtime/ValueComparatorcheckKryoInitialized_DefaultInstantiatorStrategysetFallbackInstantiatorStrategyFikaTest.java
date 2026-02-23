package org.apache.flink.api.java.typeutils.runtime;

import org.junit.jupiter.api.Test;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import org.apache.flink.types.Value;
import org.apache.flink.types.StringValue;

public class ValueComparatorcheckKryoInitialized_DefaultInstantiatorStrategysetFallbackInstantiatorStrategyFikaTest {

    @Test
    public void testSetReferenceTriggersCheckKryoInitialized() {
        ValueComparator<StringValue> comparator = new ValueComparator<>(true, StringValue.class);
        StringValue value = new StringValue("test");
        comparator.setReference(value);
    }
}
