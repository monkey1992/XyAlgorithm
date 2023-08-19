package com.xy.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class Sort {

    /**
     * 测试选择排序
     */
    @Test
    public void testSelectionSort() {
        int[] array = new int[]{1, 3, 10, 5, 7, 6, 2, 9, 8, 16};
        long timestamp = System.nanoTime();
        selectionSort(array);
        long cost = System.nanoTime() - timestamp;
        System.out.println(Arrays.toString(array) + ", cost: " + cost);
    }

    /**
     * 选择排序
     */
    private void selectionSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        // 示例：
        // 原数组：[4,2,3,1]，数组长度 length 为 4
        // 需要进行3 （length - 1 = 3）次排序：
        // 第 1 次排序结果：1,4,2,3
        // 第 2 次排序结果：1,2,4,3
        // 第 3 次排序结果：1,2,3,4
        for (int i = 0; i < length - 1; i++) {
            // 选择 array[i] 作为最小值
            int min = array[i];
            for (int j = i + 1; j < length; j++) {
                // 依次比较 i 后面的元素
                if (array[j] < min) {
                    min = array[j];
                    // 发现 j 对应的元素更小，交换 i 和 j 对应元素的位置
                    int temp = array[i];
                    array[i] = min;
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 测试冒泡排序
     */
    @Test
    public void testBubbleSort() {
        int[] array = new int[]{1, 3, 10, 5, 7, 6, 2, 9, 8, 16};
        long timestamp = System.nanoTime();
        bubbleSort(array);
        long cost = System.nanoTime() - timestamp;
        System.out.println(Arrays.toString(array) + ", cost: " + cost);
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        // 示例：
        // 原数组：[4,2,3,1]，数组长度 length 为 4
        // 需要进行3 （length - 1 = 3）次排序
        // 第 1 次排序结果：2,3,1,4（4 冒泡至数组尾部）
        // 第 2 次排序结果：2,1,3,4（3 冒泡至数组倒数第 2 位置）
        // 第 3 次排序结果：1,2,3,4（2 冒泡至数组倒数第 3 位置）
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                // 相邻元素进行比较
                if (array[j] > array[j + 1]) {
                    // 发现 j 对应的元素比 j + 1 对应的元素更大，交换 j 和 j + 1 对应元素的位置
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

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