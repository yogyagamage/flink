package org.apache.flink.api.java.typeutils.runtime.kryo;

import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class KryoSerializerSnapshot_KryoSerializerconfigureKryoLogging_LogsetLoggerFikaTest {

    @Test
    public void testConfigureKryoLogging() throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");

        String[] classNames = {
            "org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializer",
            "org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializerSnapshot"
        };

        for (String className : classNames) {
            enableTraceForLogger(className);
        }
        enableTraceForLogger("org.apache.flink.api.java.typeutils.runtime.kryo");
        enableTraceForLogger("kryo");
        enableTraceForLogger("ROOT");

        for (String className : classNames) {
            invokeConfigureKryoLogging(className);
        }

        Log.setLogger((Log.Logger) null);
    }

    private void invokeConfigureKryoLogging(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = null;

            try {
                method = clazz.getDeclaredMethod("configureKryoLogging");
            } catch (Throwable ignored) {
            }

            if (method == null) {
                try {
                    method = clazz.getMethod("configureKryoLogging");
                } catch (Throwable ignored) {
                }
            }

            if (method != null) {
                try {
                    method.setAccessible(true);
                } catch (Throwable ignored) {
                }
                method.invoke(null);
            }
        } catch (Throwable ignored) {
        }
    }

    private void enableTraceForLogger(String loggerName) {
        enableLog4j2Trace(loggerName);
        enableLogbackTrace(loggerName);
        enableJulTrace(loggerName);
    }

    private void enableLog4j2Trace(String loggerName) {
        try {
            Class<?> levelClass = Class.forName("org.apache.logging.log4j.Level");
            Object traceLevel = levelClass.getField("TRACE").get(null);

            Class<?> configuratorClass = Class.forName("org.apache.logging.log4j.core.config.Configurator");

            try {
                configuratorClass
                    .getMethod("setAllLevels", String.class, levelClass)
                    .invoke(null, loggerName, traceLevel);
            } catch (Throwable ignored) {
            }

            try {
                configuratorClass
                    .getMethod("setRootLevel", levelClass)
                    .invoke(null, traceLevel);
            } catch (Throwable ignored) {
            }
        } catch (Throwable ignored) {
        }
    }

    private void enableLogbackTrace(String loggerName) {
        try {
            Object loggerContext = Class.forName("org.slf4j.LoggerFactory")
                .getMethod("getILoggerFactory")
                .invoke(null);

            Class<?> contextClass = Class.forName("ch.qos.logback.classic.LoggerContext");
            if (!contextClass.isInstance(loggerContext)) {
                return;
            }

            Object logger = contextClass
                .getMethod("getLogger", String.class)
                .invoke(loggerContext, loggerName);

            Class<?> levelClass = Class.forName("ch.qos.logback.classic.Level");
            Object traceLevel = levelClass.getField("TRACE").get(null);

            logger.getClass()
                .getMethod("setLevel", levelClass)
                .invoke(logger, traceLevel);
        } catch (Throwable ignored) {
        }
    }

    private void enableJulTrace(String loggerName) {
        try {
            if ("ROOT".equals(loggerName)) {
                java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.ALL);
            } else {
                java.util.logging.Logger.getLogger(loggerName).setLevel(java.util.logging.Level.ALL);
            }
        } catch (Throwable ignored) {
        }
    }
}
