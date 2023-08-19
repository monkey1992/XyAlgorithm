package com.xy.algorithm.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    private int[] array;

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

    /**
     * 重置数组
     */
    private void resetArray() {
        array = new int[]{20, 1, 3, 10, 5, 7, 6, 2, 9, 8, 6, 16};
    }

    /**
     * 测试选择排序
     */
    @Test
    public void testSelectionSort() {
        selectionSort(array);
    }

    /**
     * 选择排序
     *
     * @param array 待排序数组
     */
    private void selectionSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        // 进行 length - 1 轮排序
        for (int i = 0; i < length - 1; i++) {
            // 第 i + 1 轮排序，依次比较第 i 个元素和剩下的从 i + 1 开始的 length - i - 1 个元素
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    // 发现 j 对应的元素更小，交换 i 和 j 对应元素的位置
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 测试选择排序，有输出日志
     */
    @Test
    public void testSelectionSortWithLog() {
        long timestamp = System.currentTimeMillis();
        selectionSortWithLog(array);
        long cost = System.currentTimeMillis() - timestamp;
        System.out.println(Arrays.toString(array) + ", 耗时：" + cost + " 毫秒");
    }

    /**
     * 选择排序，有输出日志
     *
     * @param array 待排序数组
     */
    private void selectionSortWithLog(int[] array) {
        System.out.println("排序前的数组：" + Arrays.toString(array) + "\n");
        if (array == null) {
            return;
        }
        int length = array.length;
        System.out.println("数组长度：" + length + "\n");
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int round = i + 1;
            System.out.println("第 " + round + " 轮排序前的数组：" + Arrays.toString(array));
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("第 " + round + " 轮排序后的数组：" + Arrays.toString(array) + "\n");
        }
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }
}
