package org.apache.flink.runtime.util.profiler;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.runtime.rest.messages.ProfilingInfo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfilingServicerequestProfiling_AsyncProfilerexecuteFikaTest {

    @Test
    void testRequestProfiling() throws IOException {
        // Create a temporary directory for profiling results
        File tempDir = Files.createTempDirectory("profiling-test").toFile();
        tempDir.deleteOnExit();
        
        // Create configuration with required options
        Configuration config = new Configuration();
        config.set(RestOptions.MAX_PROFILING_HISTORY_SIZE, 10);
        config.set(RestOptions.PROFILING_RESULT_DIR, tempDir.getAbsolutePath());
        
        // Get instance using the static factory method
        ProfilingService service = ProfilingService.getInstance(config);
        
        try {
            // Call the entry point method
            CompletableFuture<ProfilingInfo> future = service.requestProfiling(
                "test-resource-1",
                5L,
                ProfilingInfo.ProfilingMode.CPU
            );
            
            // Wait for completion to ensure execution reaches the target method
            future.join();
        } finally {
            // Clean up
            service.close();
        }
    }
}
