package org.apache.flink.api.common;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.ReadableConfig;
import org.junit.jupiter.api.Test;
import org.apache.flink.configuration.RestartStrategyOptions;

public class ExecutionConfig_RestartStrategyTypemethod_SetsnewHashSetFikaTest {

    @Test
    public void testConfigureTriggersSetsNewHashSet() {
        // Create instance using provided constructor
        ExecutionConfig executionConfig = new ExecutionConfig(new Configuration());
        
        // Create configuration that will trigger the restart strategy path
        Configuration config = new Configuration();
        config.set(RestartStrategyOptions.RESTART_STRATEGY, "fixed-delay");
        
        // Call entry point method - this should trigger the static initializers
        // which eventually call Sets.newHashSet()
        executionConfig.configure(config, Thread.currentThread().getContextClassLoader());
    }
}
