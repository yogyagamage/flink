package org.apache.flink.configuration;

import org.junit.jupiter.api.Test;
import org.apache.flink.configuration.RestartStrategyOptions.RestartStrategyType;

public class RestartStrategyTypemethod_SetsnewHashSetFikaTest {

    @Test
    public void testThirdPartyMethodInvocation() {
        // Access each enum constant to trigger static initialization
        // which calls Sets.newHashSet() in the constructor
        RestartStrategyType[] values = RestartStrategyType.values();
        
        // Access each constant individually to ensure all static initializers run
        RestartStrategyType noRestart = RestartStrategyType.NO_RESTART_STRATEGY;
        RestartStrategyType fixedDelay = RestartStrategyType.FIXED_DELAY;
        RestartStrategyType failureRate = RestartStrategyType.FAILURE_RATE;
        RestartStrategyType exponentialDelay = RestartStrategyType.EXPONENTIAL_DELAY;
        
        // Trigger class loading and static initialization if not already done
        Class<?> clazz = RestartStrategyType.class;
    }
}
