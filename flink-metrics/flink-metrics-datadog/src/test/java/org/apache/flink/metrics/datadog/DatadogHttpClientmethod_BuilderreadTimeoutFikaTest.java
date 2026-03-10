package org.apache.flink.metrics.datadog;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class DatadogHttpClientmethod_BuilderreadTimeoutFikaTest {

    @Test
    void test() {
        String apiKey = "testApiKey";
        String proxyHost = null;
        int proxyPort = 8080;
        DataCenter dataCenter = DataCenter.EU;
        boolean validateApiKey = false;

        DatadogHttpClient client = new DatadogHttpClient(
            apiKey,
            proxyHost,
            proxyPort,
            dataCenter,
            validateApiKey
        );
    }
}
