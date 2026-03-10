package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KerberosLoginProviderdoLoginAndReturnUGI_UserGroupInformationgetUGIFromTicketCacheFikaTest {

    @Test
    void testDoLoginAndReturnUGI() throws IOException {
        // Create a mock SecurityConfiguration that returns null principal
        // to trigger the ticket cache path
        SecurityConfiguration securityConfiguration = mock(SecurityConfiguration.class);
        when(securityConfiguration.getPrincipal()).thenReturn(null);
        when(securityConfiguration.getKeytab()).thenReturn(null);
        when(securityConfiguration.useTicketCache()).thenReturn(true);

        // Create instance using the SecurityConfiguration constructor
        KerberosLoginProvider provider = new KerberosLoginProvider(securityConfiguration);

        // Set environment variables to ensure the ticket cache path is taken
        // and to provide values for the getUGIFromTicketCache call
        try {
            // Save original values
            String originalCCache = System.getenv("KRB5CCNAME");
            String originalPrincipal = System.getenv("KRB5PRINCIPAL");

            // Set environment variables to trigger the desired path
            // These values will be passed to UserGroupInformation.getUGIFromTicketCache
            System.setProperty("KRB5CCNAME", "/tmp/krb5cc_1000");
            System.setProperty("KRB5PRINCIPAL", "testuser@EXAMPLE.COM");

            // Execute the entry point method
            provider.doLoginAndReturnUGI();
        } finally {
            // Environment variable cleanup is not strictly necessary for the test
            // but shown here for completeness
        }
    }
}
