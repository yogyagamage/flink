package org.apache.flink.runtime.taskexecutor;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.TaskManagerOptions;
import org.junit.jupiter.api.Test;

class SystemOutRedirectionUtilsignoreSystemOutAndError_NullPrintStreammethodFikaTest {

    @Test
    void testRedirectSystemOutAndErrorInvokesNullPrintStreamConstructor() {
        Configuration configuration = new Configuration();
        configuration.set(TaskManagerOptions.TASK_MANAGER_SYSTEM_OUT_MODE, TaskManagerOptions.SystemOutMode.IGNORE);
        
        SystemOutRedirectionUtils.redirectSystemOutAndError(configuration);
    }
}
