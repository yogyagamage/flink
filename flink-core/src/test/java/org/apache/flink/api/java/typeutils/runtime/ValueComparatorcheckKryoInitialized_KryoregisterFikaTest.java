package org.apache.flink.api.java.typeutils.runtime;

import org.junit.jupiter.api.Test;
import com.esotericsoftware.kryo.Kryo;
import org.apache.flink.types.Value;
import org.apache.flink.types.StringValue;

public class ValueComparatorcheckKryoInitialized_KryoregisterFikaTest {

    @Test
    public void testSetReferenceTriggersKryoRegister() {
        Class<StringValue> type = StringValue.class;
        boolean ascending = true;
        
        ValueComparator<StringValue> comparator = new ValueComparator<>(ascending, type);
        
        StringValue value = new StringValue("test");
        comparator.setReference(value);
    }
}
