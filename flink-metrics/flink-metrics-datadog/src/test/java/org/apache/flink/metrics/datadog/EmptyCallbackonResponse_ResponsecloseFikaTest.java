package org.apache.flink.metrics.datadog;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class EmptyCallbackonResponse_ResponsecloseFikaTest {

    @Test
    public void testOnResponseCallsClose() throws IOException {
        DatadogHttpClient.EmptyCallback callback = new DatadogHttpClient.EmptyCallback();
        
        ResponseBody body = ResponseBody.create(null, new byte[0]);
        Response response = new Response.Builder()
            .code(200)
            .message("OK")
            .request(new okhttp3.Request.Builder()
                .url("http://localhost")
                .build())
            .protocol(okhttp3.Protocol.HTTP_1_1)
            .body(body)
            .build();
        
        Call call = null;
        
        callback.onResponse(call, response);
    }
}
