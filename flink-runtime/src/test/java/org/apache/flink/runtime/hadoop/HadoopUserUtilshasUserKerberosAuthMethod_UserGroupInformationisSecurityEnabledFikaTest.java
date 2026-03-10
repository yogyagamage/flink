package org.apache.flink.runtime.hadoop;

import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;

public class HadoopUserUtilshasUserKerberosAuthMethod_UserGroupInformationisSecurityEnabledFikaTest {

    @Test
    public void testHasUserKerberosAuthMethod() {
        HadoopUserUtils instance = new HadoopUserUtils();
        UserGroupInformation ugi = UserGroupInformation.createRemoteUser("testuser");
        HadoopUserUtils.hasUserKerberosAuthMethod(ugi);
    }
}
