package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KerberosLoginProviderdoLoginAndReturnUGI_UserGroupInformationloginUserFromKeytabAndReturnUGIFikaTest {

    @Test
    void testDoLoginAndReturnUGI() throws Exception {
        SecurityConfiguration securityConfiguration = mock(SecurityConfiguration.class);
        when(securityConfiguration.getPrincipal()).thenReturn("testPrincipal");
        when(securityConfiguration.getKeytab()).thenReturn("testKeytab");
        when(securityConfiguration.useTicketCache()).thenReturn(false);

        KerberosLoginProvider kerberosLoginProvider = new KerberosLoginProvider(securityConfiguration);
        kerberosLoginProvider.doLoginAndReturnUGI();
    }
}
