package com.liuhs.list;

import java.util.Arrays;

/**
 * <B>功能简述</B><br>
 * java数组转换成List的注意事项
 *
 * @author liuhongshen
 * @date 2018/6/25 下午10:44
 */
public class ArraysAsListDemo {
    public static void main(String[] args) {

        System.out.println(Arrays.asList("a", "b"));

        System.out.println(Arrays.asList(1, 2));

        System.out.println(new Integer[]{1, 2});

        System.out.println(new int[]{1, 2});

    }
}
