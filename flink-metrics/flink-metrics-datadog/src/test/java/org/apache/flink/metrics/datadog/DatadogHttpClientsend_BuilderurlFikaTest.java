package org.apache.flink.metrics.datadog;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.flink.metrics.datadog.DatadogHttpClient.EmptyCallback;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DatadogHttpClientsend_BuilderurlFikaTest {

    @Test
    public void testSendInvokesBuilderUrl() throws Exception {
        String apiKey = "testApiKey";
        String proxyHost = null;
        int proxyPort = 8080;
        DataCenter dataCenter = DataCenter.US;
        boolean validateApiKey = false;

        DatadogHttpClient client = new DatadogHttpClient(
            apiKey,
            proxyHost,
            proxyPort,
            dataCenter,
            validateApiKey
        );

        DSeries series = Mockito.mock(DSeries.class);
        client.send(series);
    }
}
