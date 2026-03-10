package org.apache.flink.metrics.datadog;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class DatadogHttpClientmethod_MediaTypeparseFikaTest {

    @Test
    public void testSendTriggersMediaTypeParse() throws Exception {
        // Create mock DSeries
        DSeries mockDSeries = mock(DSeries.class);
        
        // Create DatadogHttpClient instance with minimal valid parameters
        DatadogHttpClient client = new DatadogHttpClient(
            "test-api-key",
            null,  // proxyHost
            0,     // proxyPort
            DataCenter.US,  // dataCenter
            false  // validateApiKey
        );
        
        // Execute the entry point method
        client.send(mockDSeries);
        
        // The static initialization of MEDIA_TYPE field will trigger MediaType.parse()
        // No assertions needed as per requirements
    }
}
