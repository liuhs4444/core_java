package com.liuhs.string;

import org.junit.Test;

public class StringDemo {

    // indexOf() substring() 执行速度非常之快，适合作为高频函数使用

    // charAt()的性能要比startWith()，endWith()的性能要高

    // 字符串累加 + concat() StringBuilder 虽然编译器优化了+，但是在迭代中还是建议使用StringBuilder
    // concat()的性能高于+ +=，低于StringBuilder


    // 反转一个字符串
    @Test
    public void reverse() {

        String base = "123456789";

        String intern = new StringBuilder(base).reverse().toString().intern();

        System.out.println("intern = " + intern);
    }

    // 打印两个为null的字符串
    @Test
    public void nullNull() {

        String a = null, b = null;

        System.out.println(a + b); // nullnull
    }

}
