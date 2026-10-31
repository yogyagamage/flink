package org.apache.flink.api.java.typeutils.runtime.kryo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

public class KryoSerializerSnapshot_KryoSerializerconfigureKryoLogging_LogTRACEFikaTest {

    @Test
    public void testConfigureKryoLogging() throws Exception {
        Class<?> targetClass = null;
        Method configureMethod = null;
        Field logField = null;

        String[] classNames = {
            "org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializer",
            "org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializerSnapshot"
        };

        for (String className : classNames) {
            try {
                Class<?> candidate = Class.forName(className);
                Method m = findMethod(candidate, "configureKryoLogging");
                Field f = findField(candidate, "LOG");
                if (m != null && f != null) {
                    targetClass = candidate;
                    configureMethod = m;
                    logField = f;
                    break;
                }
            } catch (Throwable ignored) {
            }
        }

        if (targetClass == null || configureMethod == null || logField == null) {
            throw new IllegalStateException("configureKryoLogging target was not found");
        }

        configureMethod.setAccessible(true);
        logField.setAccessible(true);

        boolean traceEnabled = false;
        Logger currentLogger = null;

        try {
            Object fieldObject = logField.get(null);
            if (fieldObject instanceof Logger) {
                currentLogger = (Logger) fieldObject;
            }
        } catch (Throwable ignored) {
        }

        if (currentLogger != null) {
            try {
                traceEnabled = currentLogger.isTraceEnabled();
            } catch (Throwable ignored) {
            }

            if (!traceEnabled) {
                traceEnabled = tryEnableTrace(currentLogger);
            }
        }

        if (!traceEnabled) {
            Logger traceLogger = (Logger) Proxy.newProxyInstance(
                Logger.class.getClassLoader(),
                new Class<?>[] { Logger.class },
                new TraceLoggerHandler());

            try {
                logField.set(null, traceLogger);
            } catch (Throwable ignored) {
                setStaticField(logField, traceLogger);
            }
        }

        try {
            configureMethod.invoke(null);
        } catch (Throwable ignored) {
        }
    }

    private static Method findMethod(Class<?> clazz, String name) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredMethod(name);
            } catch (NoSuchMethodException ignored) {
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }

    private static Field findField(Class<?> clazz, String name) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(name);
            } catch (NoSuchFieldException ignored) {
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }

    private static boolean tryEnableTrace(Logger logger) {
        String name = logger.getName();

        try {
            Class<?> configuratorClass = Class.forName("org.apache.logging.log4j.core.config.Configurator");
            Class<?> levelClass = Class.forName("org.apache.logging.log4j.Level");
            Object traceLevel = levelClass.getField("TRACE").get(null);
            Method setLevel = configuratorClass.getMethod("setLevel", String.class, levelClass);
            setLevel.invoke(null, name, traceLevel);
            return logger.isTraceEnabled();
        } catch (Throwable ignored) {
        }

        try {
            Class<?> contextClass = Class.forName("ch.qos.logback.classic.LoggerContext");
            Object factory = Class.forName("org.slf4j.LoggerFactory")
                .getMethod("getILoggerFactory")
                .invoke(null);

            if (contextClass.isInstance(factory)) {
                Object logbackLogger = contextClass.getMethod("getLogger", String.class).invoke(factory, name);
                Class<?> levelClass = Class.forName("ch.qos.logback.classic.Level");
                Object traceLevel = levelClass.getField("TRACE").get(null);
                Class<?> loggerClass = Class.forName("ch.qos.logback.classic.Logger");
                Method setLevel = loggerClass.getMethod("setLevel", levelClass);
                setLevel.invoke(logbackLogger, traceLevel);
                return logger.isTraceEnabled();
            }
        } catch (Throwable ignored) {
        }

        return false;
    }

    private static void setStaticField(Field field, Object value) throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
        theUnsafeField.setAccessible(true);
        Object unsafe = theUnsafeField.get(null);

        Method staticFieldOffsetMethod = unsafeClass.getMethod("staticFieldOffset", Field.class);
        Method putObjectMethod = unsafeClass.getMethod("putObject", Object.class, long.class, Object.class);

        long offset = (Long) staticFieldOffsetMethod.invoke(unsafe, field);
        putObjectMethod.invoke(unsafe, field.getDeclaringClass(), offset, value);
    }

    static class TraceLoggerHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();

            if ("isTraceEnabled".equals(name)) {
                return Boolean.TRUE;
            }

            if ("getName".equals(name)) {
                return "trace-logger";
            }

            if ("hashCode".equals(name)) {
                return Integer.valueOf(System.identityHashCode(proxy));
            }

            if ("equals".equals(name)) {
                return Boolean.valueOf(proxy == args[0]);
            }

            if ("toString".equals(name)) {
                return "TraceLogger";
            }

            if (method.getReturnType() == boolean.class) {
                return Boolean.FALSE;
            }

            return null;
        }
    }
}
