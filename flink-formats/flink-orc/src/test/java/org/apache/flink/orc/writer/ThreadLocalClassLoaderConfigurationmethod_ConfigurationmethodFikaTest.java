package org.apache.flink.orc.writer;

import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

public class ThreadLocalClassLoaderConfigurationmethod_ConfigurationmethodFikaTest {

    @Test
    public void testEntryPointCallsThirdPartyMethod() {
        Configuration hadoopConfig = new Configuration();
        ThreadLocalClassLoaderConfiguration instance = 
            new ThreadLocalClassLoaderConfiguration(hadoopConfig);
    }
}
