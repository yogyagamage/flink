package org.apache.flink.runtime.security.contexts;

import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;

class HadoopSecurityContextrunSecured_UserGroupInformationdoAsFikaTest {

    @Test
    void testRunSecured() throws Exception {
        UserGroupInformation ugi = UserGroupInformation.createRemoteUser("testuser");
        HadoopSecurityContext context = new HadoopSecurityContext(ugi);
        
        Callable<String> securedCallable = () -> "test";
        context.runSecured(securedCallable);
    }
}
