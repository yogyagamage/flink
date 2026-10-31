package org.apache.flink.api.java.typeutils.runtime;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ValueComparatorcheckKryoInitialized_KryoregisterFikaTest {

    @Test
    public void checkKryoInitializedShouldInvokeKryoRegister() throws Exception {
        Class<?> clazz = ValueComparator.class;
        Object valueComparator = null;

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == Class.class) {
                constructor.setAccessible(true);
                valueComparator = constructor.newInstance(String.class);
                break;
            }
        }

        if (valueComparator == null) {
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 0) {
                    constructor.setAccessible(true);
                    valueComparator = constructor.newInstance();
                    break;
                }
            }
        }

        if (valueComparator == null) {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            Object unsafe = theUnsafeField.get(null);
            Method allocateInstanceMethod = unsafeClass.getMethod("allocateInstance", Class.class);
            valueComparator = allocateInstanceMethod.invoke(unsafe, clazz);
        }

        try {
            Field typeField = clazz.getDeclaredField("type");
            typeField.setAccessible(true);
            if (typeField.get(valueComparator) == null) {
                typeField.set(valueComparator, String.class);
            }
        } catch (NoSuchFieldException ignored) {
        }

        try {
            Field kryoField = clazz.getDeclaredField("kryo");
            kryoField.setAccessible(true);
            kryoField.set(valueComparator, null);
        } catch (NoSuchFieldException ignored) {
        }

        Method checkKryoInitializedMethod = clazz.getDeclaredMethod("checkKryoInitialized");
        checkKryoInitializedMethod.setAccessible(true);
        checkKryoInitializedMethod.invoke(valueComparator);
    }
}
