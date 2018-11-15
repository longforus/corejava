package com.longforus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by XQ Yang on 2018/2/1  19:28.
 * Description :
 */

class TestProxy {
    public static void main(String[] args) {
        Object[] objects = new Object[1000];
        for (int i = 0; i < objects.length; i++) {
            Integer value = i + 1;
            MethodHandler handler = new MethodHandler(value);
            Object o = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
            objects[i] = o;
        }

        int i = Arrays.binarySearch(objects, 130);
        System.out.println("result = " + i);
    }
}

class MethodHandler implements InvocationHandler {

    private final Object mValue;

    public MethodHandler(Object value) {
        mValue = value;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy = " + mValue);
        System.out.println(method.getName());
        for (Object arg : args) {
            System.out.print(arg + ",");
        }
        System.out.println();
        return method.invoke(mValue, args);
    }
}
