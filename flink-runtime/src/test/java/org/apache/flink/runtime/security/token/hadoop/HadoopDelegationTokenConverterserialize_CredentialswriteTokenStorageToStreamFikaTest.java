package org.apache.flink.runtime.security.token.hadoop;

import org.apache.hadoop.io.DataOutputBuffer;
import org.apache.hadoop.security.Credentials;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HadoopDelegationTokenConverterserialize_CredentialswriteTokenStorageToStreamFikaTest {

    @Test
    public void testSerialize() throws IOException {
        HadoopDelegationTokenConverter converter = new HadoopDelegationTokenConverter();
        Credentials credentials = new Credentials();
        converter.serialize(credentials);
    }
}
