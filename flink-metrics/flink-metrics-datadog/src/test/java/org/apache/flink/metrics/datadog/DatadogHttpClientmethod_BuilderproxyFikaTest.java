package org.apache.flink.metrics.datadog;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class DatadogHttpClientmethod_BuilderproxyFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        String apiKey = "testApiKey123";
        String proxyHost = "proxy.example.com";
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
