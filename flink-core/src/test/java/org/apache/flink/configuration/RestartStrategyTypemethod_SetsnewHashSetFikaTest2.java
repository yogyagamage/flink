package org.apache.flink.configuration;

import org.apache.flink.configuration.RestartStrategyOptions.RestartStrategyType;
import org.junit.jupiter.api.Test;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest2 {

    @Test
    public void testOfMethodTriggersSetsNewHashSet() {
        // This call will trigger the static initializer which creates enum instances
        // Each enum instance constructor calls Sets.newHashSet()
        RestartStrategyType result = RestartStrategyType.of("disable");
    }
}
