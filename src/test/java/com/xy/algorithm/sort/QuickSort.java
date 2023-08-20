package com.xy.algorithm.sort;

import org.junit.Test;

/**
 * 快速排序
 * 时间复杂度：平均 O(n log n)，最差情况 O(n²)，取决于基准值
 */
public class QuickSort extends BaseSort {

    /**
     * 测试快速排序
     */
    @Test
    @Override
    public void testSort() {
        super.testSort();
    }

    /**
     * 快速排序
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
        quickSort(array, 0, length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        if (left > right) {
            return;
        }

        int pivot = array[left];
        int leftCursor = left;
        int rightCursor = right;

        while (leftCursor < rightCursor) {
            while (leftCursor < rightCursor && array[rightCursor] >= pivot) {
                rightCursor--;
            }

            while (leftCursor < rightCursor && array[leftCursor] <= pivot) {
                leftCursor++;
            }

            if (leftCursor < rightCursor) {
                // 交换数组元素
                int tempRight = array[rightCursor];
                int tempLeft = array[leftCursor];
                System.out.println(tempLeft + " 和 " + tempRight + " 交换");
                array[rightCursor] = tempLeft;
                array[leftCursor] = tempRight;
            }
        }

        // 交换 pivot 对应的数组元素
        array[left] = array[leftCursor];
        array[leftCursor] = pivot;

        quickSort(array, left, rightCursor - 1);
        quickSort(array, rightCursor + 1, right);
    }

    /**
     * 测试快速排序，有输出日志
     */
    @Test
    @Override
    public void testSortWithLog() {
        super.testSortWithLog();
    }

    /**
     * 快速排序，有输出日志
     */
    @Override
    public void sortWithLog(int[] array) {

    }
}