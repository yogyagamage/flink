package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest {

    @Test
    public void testOfMethodTriggersSetsNewHashSet() {
        // This call will trigger the static initializer which contains Sets.newHashSet()
        RestartStrategyOptions.RestartStrategyType.of("none");
    }
}
