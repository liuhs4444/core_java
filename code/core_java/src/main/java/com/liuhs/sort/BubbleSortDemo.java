package com.liuhs.sort;

public class BubbleSortDemo {

    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        boolean change = true;
        for (int i = 1; i < ints.length && change; i++) {
            System.out.println("j = " + "00000000000000");
            change = false;
            for (int j = 0; j < ints.length - i; ++j) { // ints.length-i 理论上应该<ints.length
                if (ints[j] > ints[j + 1]) {            // 但其实每次是前一个元素与下一个元素相比较
                    int temp = ints[j];                 // 这块也相当于一个优化，减少循环次数

                    ints[j] = ints[j + 1];

                    ints[j + 1] = temp;

                    change = true;
                }
            }
        }

    }
}
