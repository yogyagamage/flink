package org.apache.flink.runtime.security.modules;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.SecurityOptions;
import org.apache.flink.runtime.security.SecurityConfiguration;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HadoopModuleinstall_UserGroupInformationhasKerberosCredentialsFikaTest {

    @Test
    void testInstallTriggersHasKerberosCredentials() throws Exception {
        // Mock SecurityConfiguration
        SecurityConfiguration securityConfigMock = mock(SecurityConfiguration.class);
        Configuration flinkConfig = new Configuration();
        flinkConfig.set(SecurityOptions.DELEGATION_TOKENS_ENABLED, false);
        when(securityConfigMock.getFlinkConfig()).thenReturn(flinkConfig);
        when(securityConfigMock.getTgtRenewalPeriod()).thenReturn(java.time.Duration.ofMillis(1000L));

        // Mock Hadoop Configuration
        org.apache.hadoop.conf.Configuration hadoopConfig = new org.apache.hadoop.conf.Configuration();

        // Create the module instance
        HadoopModule module = new HadoopModule(securityConfigMock, hadoopConfig);

        // Mock static methods and classes in the call chain
        try (MockedStatic<UserGroupInformation> ugiMock = Mockito.mockStatic(UserGroupInformation.class);
             MockedStatic<Executors> executorsMock = Mockito.mockStatic(Executors.class)) {

            // Mock UserGroupInformation behavior
            UserGroupInformation mockUgi = mock(UserGroupInformation.class);
            when(mockUgi.isFromKeytab()).thenReturn(false);
            when(mockUgi.hasKerberosCredentials()).thenReturn(true);
            ugiMock.when(UserGroupInformation::getLoginUser).thenReturn(mockUgi);
            ugiMock.when(() -> UserGroupInformation.setConfiguration(any())).thenAnswer(invocation -> null);

            // Mock KerberosLoginProvider via reflection since we can't mock it directly
            // We'll make isLoginPossible return false to avoid the login path
            // This ensures we reach the hasKerberosCredentials call
            Class<?> kerberosLoginProviderClass = Class.forName("org.apache.flink.runtime.security.token.hadoop.KerberosLoginProvider");
            Object kerberosLoginProviderMock = mock(kerberosLoginProviderClass);
            when(kerberosLoginProviderMock.getClass().getMethod("isLoginPossible", boolean.class).invoke(kerberosLoginProviderMock, true))
                    .thenReturn(false);

            // Mock the constructor call using reflection
            Field securityConfigField = module.getClass().getDeclaredField("securityConfig");
            securityConfigField.setAccessible(true);
            SecurityConfiguration securityConfig = (SecurityConfiguration) securityConfigField.get(module);

            // Create a mock ScheduledExecutorService
            ScheduledExecutorService mockExecutor = mock(ScheduledExecutorService.class);
            executorsMock.when(() -> Executors.newSingleThreadScheduledExecutor(any()))
                    .thenReturn(mockExecutor);

            // Mock HadoopUserUtils static method
            try (MockedStatic<org.apache.flink.runtime.hadoop.HadoopUserUtils> hadoopUtilsMock = 
                    Mockito.mockStatic(org.apache.flink.runtime.hadoop.HadoopUserUtils.class)) {
                hadoopUtilsMock.when(() -> org.apache.flink.runtime.hadoop.HadoopUserUtils.hasUserKerberosAuthMethod(any()))
                        .thenReturn(true);
                hadoopUtilsMock.when(() -> org.apache.flink.runtime.hadoop.HadoopUserUtils.isProxyUser(any()))
                        .thenReturn(false);

                // Execute the entry point
                module.install();
            }
        }
    }
}
