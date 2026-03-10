package org.apache.flink.runtime.checkpoint;

import org.apache.flink.runtime.state.StateObject;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class StateObjectCollectionequals_CollectionUtilsisEqualCollectionFikaTest {

    @Test
    void testEqualsInvokesCollectionUtilsIsEqualCollection() {
        // Create first collection with some content
        Collection<StateObject> collection1 = new ArrayList<>();
        StateObjectCollection<StateObject> soc1 = new StateObjectCollection<>(collection1);
        
        // Create second collection with same content
        Collection<StateObject> collection2 = new ArrayList<>();
        StateObjectCollection<StateObject> soc2 = new StateObjectCollection<>(collection2);
        
        // This call should traverse through equals() -> CollectionUtils.isEqualCollection()
        soc1.equals(soc2);
    }
}
