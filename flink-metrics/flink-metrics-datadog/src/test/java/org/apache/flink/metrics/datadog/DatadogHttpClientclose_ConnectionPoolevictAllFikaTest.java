package org.apache.flink.metrics.datadog;

import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.flink.metrics.datadog.DatadogHttpClient.EmptyCallback;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class DatadogHttpClientclose_ConnectionPoolevictAllFikaTest {

    @Test
    void testCloseEvictAll() throws Exception {
        String apiKey = "testApiKey";
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

        client.close();
    }
}
