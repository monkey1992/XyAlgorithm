package com.xy.algorithm;

public class Test {

    /**
     * 99 乘法表
     */
    @org.junit.Test
    public void test() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (i == j) {
                    System.out.println(j + " x " + i + " = " + (i * j));
                } else {
                    System.out.print(j + " x " + i + " = " + (i * j) + " ");
                }
            }
        }
    }
}
