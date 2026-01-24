package org.apache.flink.configuration;

import org.apache.flink.configuration.RestartStrategyOptions.RestartStrategyType;
import org.junit.jupiter.api.Test;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest {

    @Test
    public void testOfMethodTriggersStaticInitializer() {
        // This call will trigger the static initializer which calls Sets.newHashSet
        RestartStrategyType.of("disable");
    }
}
