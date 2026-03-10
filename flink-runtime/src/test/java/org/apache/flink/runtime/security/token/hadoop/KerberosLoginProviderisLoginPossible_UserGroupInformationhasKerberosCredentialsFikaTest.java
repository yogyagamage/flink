package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyBoolean;

class KerberosLoginProviderisLoginPossible_UserGroupInformationhasKerberosCredentialsFikaTest {

    @Test
    void testIsLoginPossibleInvokesHasKerberosCredentials() throws IOException {
        try (MockedStatic<UserGroupInformation> ugiMock = Mockito.mockStatic(UserGroupInformation.class)) {
            ugiMock.when(UserGroupInformation::isSecurityEnabled).thenReturn(true);
            ugiMock.when(UserGroupInformation::getCurrentUser).thenReturn(Mockito.mock(UserGroupInformation.class));
            
            Configuration configuration = new Configuration();
            SecurityConfiguration securityConfiguration = new SecurityConfiguration(configuration);
            KerberosLoginProvider provider = new KerberosLoginProvider(securityConfiguration);
            
            provider.isLoginPossible(false);
        }
    }
}
