package com.sjw.leetcode100;


import com.sjw.leetcode100.base.BaseCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> c = Class.forName("com.sjw.leetcode100.cases.PathSumThree");
        Method method = c.getMethod("run");
        method.invoke(c.getDeclaredConstructor().newInstance());
    }
}
