package com.xy.algorithm;

import org.junit.Test;

public class Sort {

    @Test
    public void testBinarySearch() {
        int[] array = new int[]{1, 3, 6, 8, 9, 12, 16, 22, 30, 35, 37, 46, 55, 61, 70, 76, 77, 81, 82, 86, 92, 96, 100};
        int target = 100;
        int index = binarySearch(array, target, 0, array.length - 1);
        if (index > -1) {
            System.out.println("testBinarySearch success, target: " + target + ", index: " + index + ", item: " + array[index]);
        } else {
            System.out.println("testBinarySearch failure, target: " + target);
        }
    }

    private int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int item = array[mid];
        if (item > target) {
            high = mid - 1;
        } else if (item < target) {
            low = mid + 1;
        } else {
            return mid;
        }
        return binarySearch(array, target, low, high);
    }
}
