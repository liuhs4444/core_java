package com.liuhs.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] ints = {1, 4, 7, 3, 9, 5};

        // 第一次循环最大的数排在最右边，依次类推，只需要数组的长度-1次就能排完
        for (int i = 1; i < ints.length; ++i) {
            for (int j = 0; j < ints.length - i; ++j) { // ints.length-i 理论上应该<ints.length
                if (ints[j] > ints[j + 1]) {            // 但其实每次是前一个元素与下一个元素相比较
                    int temp = ints[j];                 // 这块也相当于一个优化，减少循环次数

                    ints[j] = ints[j + 1];

                    ints[j + 1] = temp;

                }
            }
        }

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }
}
