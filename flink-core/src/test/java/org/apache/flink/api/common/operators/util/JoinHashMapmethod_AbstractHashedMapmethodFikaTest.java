package org.apache.flink.api.common.operators.util;

import org.apache.flink.api.common.typeutils.TypeComparator;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class JoinHashMapmethod_AbstractHashedMapmethodFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        TypeSerializer<Object> mockSerializer = Mockito.mock(TypeSerializer.class);
        TypeComparator<Object> mockComparator = Mockito.mock(TypeComparator.class);
        
        JoinHashMap<Object> joinHashMap = new JoinHashMap<>(mockSerializer, mockComparator);
    }
}
