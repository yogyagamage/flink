package org.apache.flink.configuration;

import org.apache.flink.configuration.RestartStrategyOptions.RestartStrategyType;
import org.junit.jupiter.api.Test;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest2 {

    @Test
    public void testOfMethodTriggersSetsNewHashSet() {
        // This call will trigger the static initialization of RestartStrategyType
        // which will invoke the constructor with Sets.newHashSet()
        RestartStrategyType result = RestartStrategyType.of("disable");
    }
}
