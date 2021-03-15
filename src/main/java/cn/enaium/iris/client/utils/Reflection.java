package cn.enaium.iris.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@SuppressWarnings("all")
public class Reflection {
    public static Method getMethod(String className, String methodName, Class<?>... types) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return Class.forName(className).getMethod(methodName, types);
    }

    public static <T> T getValue(Object object, String fieldName) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        return (T) Class.forName(object.getClass().getName()).getField(fieldName).get(object);
    }

    public static void setValue(Object object, String fieldName, Object value) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Class.forName(object.getClass().getName()).getField(fieldName).set(object, value);
    }

}
