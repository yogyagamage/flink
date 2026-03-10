package org.apache.flink.metrics.datadog;

import okhttp3.Call;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class EmptyCallbackonResponse_ResponseisSuccessfulFikaTest {

    @Test
    void testOnResponse() throws IOException {
        // Create instance using the provided constructor
        DatadogHttpClient.EmptyCallback callback = new DatadogHttpClient.EmptyCallback();
        
        // Create mock objects for the method parameters
        Call mockCall = Mockito.mock(Call.class);
        Response mockResponse = Mockito.mock(Response.class);
        
        // Configure the mock response to ensure isSuccessful() is called
        Mockito.when(mockResponse.isSuccessful()).thenReturn(true);
        
        // Call the entry point method
        callback.onResponse(mockCall, mockResponse);
    }
}
