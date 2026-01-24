package org.apache.flink.api.common.operators.util;

import org.apache.flink.api.common.typeutils.TypeComparator;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JoinHashMapinsertOrReplace_HashEntrysetValueFikaTest {

    @Test
    public void testInsertOrReplaceCallsHashEntrySetValue() throws Exception {
        TypeSerializer<Object> mockSerializer = Mockito.mock(TypeSerializer.class);
        TypeComparator<Object> mockComparator = Mockito.mock(TypeComparator.class);
        
        when(mockComparator.hash(any())).thenReturn(1);
        when(mockComparator.equalToReference(any())).thenReturn(true);
        
        JoinHashMap<Object> map = new JoinHashMap<>(mockSerializer, mockComparator);
        
        Object testRecord = new Object();
        map.insertOrReplace(testRecord);
        
        map.insertOrReplace(testRecord);
    }
}
