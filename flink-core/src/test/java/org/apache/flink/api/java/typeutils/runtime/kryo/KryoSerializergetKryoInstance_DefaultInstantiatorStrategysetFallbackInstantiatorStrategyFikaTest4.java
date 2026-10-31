package org.apache.flink.api.java.typeutils.runtime.kryo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class KryoSerializergetKryoInstance_DefaultInstantiatorStrategysetFallbackInstantiatorStrategyFikaTest4 {

    @Test
    public void testGetKryoInstance() throws Exception {
        Class<?> serializerClass = Class.forName("org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializer");
        Object serializer = null;

        try {
            Constructor<?> constructor = serializerClass.getDeclaredConstructor(Class.class);
            constructor.setAccessible(true);
            serializer = constructor.newInstance(String.class);
        } catch (Throwable ignored) {
        }

        if (serializer == null) {
            try {
                Class<?> typeInformationClass = Class.forName("org.apache.flink.api.common.typeinfo.TypeInformation");
                Object typeInformation = typeInformationClass.getMethod("of", Class.class).invoke(null, String.class);
                Constructor<?> constructor = serializerClass.getDeclaredConstructor(typeInformationClass);
                constructor.setAccessible(true);
                serializer = constructor.newInstance(typeInformation);
            } catch (Throwable ignored) {
            }
        }

        if (serializer == null) {
            try {
                Class<?> registrarClass = Class.forName("org.apache.flink.api.java.typeutils.runtime.kryo.FlinkChillPackageRegistrar");
                Constructor<?> constructor = serializerClass.getDeclaredConstructor(Class.class, registrarClass);
                constructor.setAccessible(true);
                serializer = constructor.newInstance(String.class, null);
            } catch (Throwable ignored) {
            }
        }

        if (serializer == null) {
            try {
                Class<?> typeInformationClass = Class.forName("org.apache.flink.api.common.typeinfo.TypeInformation");
                Object typeInformation = typeInformationClass.getMethod("of", Class.class).invoke(null, String.class);
                Class<?> registrarClass = Class.forName("org.apache.flink.api.java.typeutils.runtime.kryo.FlinkChillPackageRegistrar");
                Constructor<?> constructor = serializerClass.getDeclaredConstructor(typeInformationClass, registrarClass);
                constructor.setAccessible(true);
                serializer = constructor.newInstance(typeInformation, null);
            } catch (Throwable ignored) {
            }
        }

        if (serializer == null) {
            try {
                Constructor<?> constructor = serializerClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                serializer = constructor.newInstance();
            } catch (Throwable ignored) {
            }
        }

        if (serializer == null) {
            for (Constructor<?> constructor : serializerClass.getDeclaredConstructors()) {
                constructor.setAccessible(true);
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] arguments = new Object[parameterTypes.length];

                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];

                    if (parameterType == Class.class) {
                        arguments[i] = String.class;
                    } else if (parameterType.getName().equals("org.apache.flink.api.common.typeinfo.TypeInformation")) {
                        try {
                            arguments[i] = parameterType.getMethod("of", Class.class).invoke(null, String.class);
                        } catch (Throwable ignored) {
                        }
                    } else if (parameterType == Object.class) {
                        arguments[i] = new Object();
                    } else if (parameterType == boolean.class) {
                        arguments[i] = Boolean.FALSE;
                    } else if (parameterType == byte.class) {
                        arguments[i] = (byte) 0;
                    } else if (parameterType == short.class) {
                        arguments[i] = (short) 0;
                    } else if (parameterType == int.class) {
                        arguments[i] = 0;
                    } else if (parameterType == long.class) {
                        arguments[i] = 0L;
                    } else if (parameterType == float.class) {
                        arguments[i] = 0.0F;
                    } else if (parameterType == double.class) {
                        arguments[i] = 0.0D;
                    } else if (parameterType == char.class) {
                        arguments[i] = '\0';
                    }
                }

                try {
                    serializer = constructor.newInstance(arguments);
                    break;
                } catch (Throwable ignored) {
                }
            }
        }

        if (serializer == null) {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafeField.setAccessible(true);
                Object unsafe = theUnsafeField.get(null);
                Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
                serializer = allocateInstance.invoke(unsafe, serializerClass);

                for (Field field : serializerClass.getDeclaredFields()) {
                    if (field.getType() == Class.class) {
                        field.setAccessible(true);
                        try {
                            field.set(serializer, String.class);
                        } catch (Throwable ignored) {
                        }
                    } else if (field.getType().getName().equals("org.apache.flink.api.common.typeinfo.TypeInformation")) {
                        field.setAccessible(true);
                        try {
                            Object typeInformation = field.getType().getMethod("of", Class.class).invoke(null, String.class);
                            field.set(serializer, typeInformation);
                        } catch (Throwable ignored) {
                        }
                    }
                }
            } catch (Throwable ignored) {
            }
        }

        if (serializer == null) {
            throw new IllegalStateException("Unable to create KryoSerializer instance.");
        }

        Method getKryoInstance = null;
        Class<?> currentClass = serializerClass;
        while (currentClass != null && getKryoInstance == null) {
            try {
                getKryoInstance = currentClass.getDeclaredMethod("getKryoInstance");
            } catch (NoSuchMethodException ignored) {
            }
            currentClass = currentClass.getSuperclass();
        }

        if (getKryoInstance == null) {
            throw new NoSuchMethodException("getKryoInstance");
        }

        getKryoInstance.setAccessible(true);
        getKryoInstance.invoke(serializer);
    }
}
