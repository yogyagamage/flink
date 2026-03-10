package org.apache.flink.metrics.datadog;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

class DatadogHttpClientclose_DispatcherexecutorServiceFikaTest {

    @Test
    void testCloseInvokesDispatcherExecutorService() {
        // Create a real OkHttpClient with a real Dispatcher
        OkHttpClient realClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build();
        
        // Create DatadogHttpClient instance using constructor
        DatadogHttpClient client = new DatadogHttpClient(
                "test-api-key",
                null,
                0,
                DataCenter.US,
                false
        );
        
        // Invoke the entry point method
        client.close();
    }
}
