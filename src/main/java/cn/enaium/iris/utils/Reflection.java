package cn.enaium.iris.utils;

import org.lwjgl.system.CallbackI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@SuppressWarnings("all")
public class Reflection {
    public static Method getMethod(String name, Class<?>... types) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = name.split("\\.")[0];
        String methodName = name.split("\\.")[1];
        return Class.forName(className).getMethod(methodName, types);
    }

    public static <T> T getValue(Object object, String name) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        String className = name.split("\\.")[0];
        String fieldName = name.split("\\.")[1];
        return (T) Class.forName(className).getField(fieldName).get(object);
    }
}
