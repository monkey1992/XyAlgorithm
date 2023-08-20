package com.xy.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n²)
 */
public class BubbleSort extends BaseSort {

    /**
     * 测试冒泡排序
     */
    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     */
    @Override
    public void sort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            // 是否有执行过交换
            boolean hasSwapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                // 相邻元素进行比较
                if (array[j] > array[j + 1]) {
                    hasSwapped = true;
                    // 发现 j 对应的元素比 j + 1 对应的元素更大，交换 j 和 j + 1 对应元素的位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!hasSwapped) {
                // 没有执行过交换，说明数组已全部排好序，不需要再继续进行排序了
                break;
            }
        }
    }

    /**
     * 测试冒泡排序，有输出日志
     */
    @Test
    @Override
    public void testSortWithLog() {
        super.testSortWithLog();
    }

    /**
     * 冒泡排序，有输出日志
     *
     * @param array 待排序数组
     */
    @Override
    public void sortWithLog(int[] array) {
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
            boolean hasSwapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                // 相邻元素进行比较
                if (array[j] > array[j + 1]) {
                    hasSwapped = true;
                    // 发现 j 对应的元素比 j + 1 对应的元素更大，交换 j 和 j + 1 对应元素的位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第 " + round + " 轮排序后的数组：" + Arrays.toString(array));
            if (hasSwapped) {
                System.out.println("第 " + round + " 轮执行过交换，不确定数组是否已全部排好序，继续排序" + "\n");
            } else {
                System.out.println("第 " + round + " 轮未执行过交换，数组排序完毕！" + "\n");
                break;
            }
        }
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }
}