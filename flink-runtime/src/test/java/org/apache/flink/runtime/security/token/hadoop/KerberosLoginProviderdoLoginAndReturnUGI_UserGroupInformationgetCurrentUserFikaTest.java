package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class KerberosLoginProviderdoLoginAndReturnUGI_UserGroupInformationgetCurrentUserFikaTest {

    @Test
    void testDoLoginAndReturnUGI() throws IOException {
        // Create a minimal Configuration that will result in principal being null
        // This will trigger the branch that calls UserGroupInformation.getCurrentUser()
        Configuration configuration = new Configuration();
        
        // Create KerberosLoginProvider using the Configuration constructor
        KerberosLoginProvider provider = new KerberosLoginProvider(configuration);
        
        // Execute the entry point method
        provider.doLoginAndReturnUGI();
    }
}
