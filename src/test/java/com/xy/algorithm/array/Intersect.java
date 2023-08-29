package com.xy.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组系列
 * 两个数组的交集II
 * <p>
 * LeetCode地址：https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * <p>
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {

    @Test
    public void testIntersect() {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
//        int[] result = intersect1(nums1, nums2);
        int[] result = intersect2(nums1, nums2);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int valI = nums1[i];
            Integer time = map.get(valI);
            if (time == null) {
                map.put(valI, 1);
            } else {
                map.put(valI, time + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int valI = nums2[i];
            Integer time = map.get(valI);
            if (time != null) {
                if (time > 1) {
                    map.put(valI, time - 1);
                } else {
                    map.remove(valI);
                }
                list.add(valI);
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int valI = nums1[i];
            int valJ = nums2[j];
            if (valI == valJ) {
                list.add(valI);
                i++;
                j++;
            } else if (valI > valJ) {
                j++;
            } else {
                i++;
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int k = 0; k < size; k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}
