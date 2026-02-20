package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.apache.flink.configuration.RestartStrategyOptions.RestartStrategyType;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest {

    @Test
    public void testRestartStrategyTypeInitialization() {
        // Access all enum values to trigger static initializers
        RestartStrategyType[] values = RestartStrategyType.values();
        
        // Access each enum constant to ensure static initialization completes
        RestartStrategyType noRestart = RestartStrategyType.NO_RESTART_STRATEGY;
        RestartStrategyType fixedDelay = RestartStrategyType.FIXED_DELAY;
        RestartStrategyType failureRate = RestartStrategyType.FAILURE_RATE;
        RestartStrategyType exponentialDelay = RestartStrategyType.EXPONENTIAL_DELAY;
    }
}
