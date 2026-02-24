package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.apache.commons.compress.utils.Sets;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest2 {

    @Test
    public void testOfMethodTriggersSetsNewHashSet() {
        // This will trigger the static initializer which calls Sets.newHashSet
        // through the constructor of RestartStrategyType enum constants
        RestartStrategyOptions.RestartStrategyType.of("disable");
    }
}
