package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.token.hadoop.HadoopFSDelegationTokenProvider;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class HadoopFSDelegationTokenProviderdelegationTokensRequired_UserGroupInformationgetCurrentUserFikaTest {

    @Test
    void testDelegationTokensRequired() throws Exception {
        HadoopFSDelegationTokenProvider provider = new HadoopFSDelegationTokenProvider();
        
        Configuration flinkConfig = new Configuration();
        provider.init(flinkConfig);
        
        provider.delegationTokensRequired();
    }
}
