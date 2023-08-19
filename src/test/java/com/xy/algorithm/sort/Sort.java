package com.xy.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class Sort {

    /**
     * 测试快速排序
     */
    @Test
    public void testQuickSort() {
        int[] array = new int[]{1, 3, 10, 5, 7, 6, 2, 9, 8, 16};
//        int[] array = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        long timestamp = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long cost = System.nanoTime() - timestamp;
        System.out.println(Arrays.toString(array) + ", cost: " + cost);
    }

    /**
     * 快速排序
     */
    private void quickSort(final int[] array, final int left, final int right) {
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
        // [1, 3, 10, 5, 7, 6, 2, 9, 8, 16]
        // pivot = 1
        // 第 1 次排序结果：[] 1 [3, 10, 5, 7, 6, 2, 9, 8, 16]
        // 第 2 次排序结果：1 [2] 3 [10, 5, 7, 6, 9, 8, 16]
        // 第 3 次排序结果：1 2 3 [5, 7, 6, 9, 8] 10 [16]
        // 第 4 次排序结果：1 2 3 5 [7, 6, 9, 8] 10 16
        // 第 5 次排序结果：1 2 3 5 [6] 7 [9, 8] 10 16
        // 第 6 次排序结果：1 2 3 5 6 7 [8] 9 10 16
        // 第 7 次排序结果：1 2 3 5 6 7 8 9 10 16

        // [5, 3, 10, 1, 7, 6, 2, 9, 8, 16]
        // 10, 2 交换
        // [5, 3, 2, 1, 7, 6, 10, 9, 8, 16]
        // 5, 1 交换
        // [1, 3, 2, 5, 7, 6, 10, 9, 8, 16]

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
}