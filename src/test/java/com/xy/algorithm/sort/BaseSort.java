package com.xy.algorithm.sort;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

public abstract class BaseSort {

    int[] array;

    /**
     * 重置数组
     */
    private void resetArray() {
        array = new int[]{20, 1, 3, 10, 5, 7, 6, 2, 9, 8, 6, 16};
    }

    @Before
    public void before() {
        System.out.println("before: " + Arrays.toString(array));
        resetArray();
        System.out.println("before resetArray: " + Arrays.toString(array));
    }

    @After
    public void after() {
        System.out.println("after: " + Arrays.toString(array));
        resetArray();
        System.out.println("after resetArray: " + Arrays.toString(array));
    }

    public abstract void testSort();

    public abstract void sort(int[] array);

    public abstract void testSortWithLog();

    public abstract void sortWithLog(int[] array);
}
