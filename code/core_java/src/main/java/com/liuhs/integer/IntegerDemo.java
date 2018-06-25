package com.liuhs.integer;

import java.lang.reflect.Field;

public class IntegerDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // -128-127
        Integer var1 = 100, var2 = 100;
        System.out.println(var1 == var2); // true

        // -128
        Integer var3 = -128, var4 = -128;
        System.out.println(var3 == var4); // true

        // -129
        Integer var5 = -129, var6 = -129;
        System.out.println(var5 == var6); // false

        // 127
        Integer var7 = 127, var8 = 127;
        System.out.println(var7 == var8); // true

        // 128
        Integer var9 = 128, var10 = 128;
        System.out.println(var9 == var10); // false

        /*IntegerCache这个内部私有类，它为-128到127之间的所有整数对象提供缓存。
          因为在这个范围内的小数值整数使用频率要比其它的大得多，可以通过该设置进行有效的内存优化。*/
        Integer integer = Integer.valueOf("127");
        System.out.println("integer = " + integer);


        // 测试
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);

        Integer[] newCache = (Integer[]) myCache.get(cache);
        System.out.println("newCache.length = " + newCache.length);
        for (int i = 0; i < newCache.length; i++) {
            System.out.println("newCache[" + i + "] = " + newCache[i]);
        }
        newCache[132] = newCache[133]; // newCache[132]=4，是原始数值，将值换成5

        int a = 2;
        Integer b = a + a; // a+a=4，赋值给Integer，去寻找下标[132]的值，因为已经替换成5，所以打印值为5

        System.out.println("b = " + b); // 5
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
