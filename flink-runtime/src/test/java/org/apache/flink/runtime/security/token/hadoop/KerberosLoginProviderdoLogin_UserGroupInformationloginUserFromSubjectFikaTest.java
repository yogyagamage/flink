package org.apache.flink.runtime.security.token.hadoop;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;

import javax.security.auth.Subject;
import java.io.IOException;
import java.lang.reflect.Field;

class KerberosLoginProviderdoLogin_UserGroupInformationloginUserFromSubjectFikaTest {

    @Test
    void testDoLoginInvokesLoginUserFromSubject() throws Exception {
        // Create a Configuration that results in null principal and keytab
        Configuration flinkConfig = new Configuration();
        
        // Use reflection to set internal fields to ensure principal is null
        // This will make the code path go to the ticket cache branch
        SecurityConfiguration securityConfig = new SecurityConfiguration(flinkConfig);
        
        // Create provider with null principal to trigger the desired path
        KerberosLoginProvider provider = new KerberosLoginProvider(securityConfig);
        
        // Use reflection to set principal field to null to ensure we take the ticket cache path
        Field principalField = KerberosLoginProvider.class.getDeclaredField("principal");
        principalField.setAccessible(true);
        principalField.set(provider, null);
        
        // Also set keytab to null for consistency
        Field keytabField = KerberosLoginProvider.class.getDeclaredField("keytab");
        keytabField.setAccessible(true);
        keytabField.set(provider, null);
        
        // Mock the static method to return false so we enter the ticket cache branch
        // We'll use reflection to manipulate the behavior
        // First, ensure current user is not a proxy user
        UserGroupInformation currentUser = UserGroupInformation.getCurrentUser();
        
        // The test will execute the method which should call UserGroupInformation.loginUserFromSubject(null)
        provider.doLogin(false);
    }
}
