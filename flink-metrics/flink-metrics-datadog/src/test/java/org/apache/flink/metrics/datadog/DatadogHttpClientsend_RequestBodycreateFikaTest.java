package org.apache.flink.metrics.datadog;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class DatadogHttpClientsend_RequestBodycreateFikaTest {

    @Test
    public void testSend() throws Exception {
        String apiKey = "test-api-key";
        String proxyHost = null;
        int proxyPort = 0;
        DataCenter dataCenter = DataCenter.US;
        boolean validateApiKey = false;

        DatadogHttpClient client = new DatadogHttpClient(
            apiKey,
            proxyHost,
            proxyPort,
            dataCenter,
            validateApiKey
        );

        DSeries request = Mockito.mock(DSeries.class);
        client.send(request);
    }
}
