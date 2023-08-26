package com.xy.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组系列
 * 三数之和
 * <p>
 * LeetCode地址：https://leetcode.cn/problems/3sum/
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {

    @Test
    public void testThreeSum() {
//        int[] nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] nums = new int[]{0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        if (length == 3) {
            int value0 = nums[0];
            int value1 = nums[1];
            int value2 = nums[2];
            if (value0 + value1 + value2 == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(value0);
                list.add(value1);
                list.add(value2);
                result.add(list);
                return result;
            }
            return result;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int valueI = nums[i];
                    int valueJ = nums[j];
                    int valueK = nums[k];
                    if (valueI + valueJ + valueK == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(valueI);
                        list.add(valueJ);
                        list.add(valueK);
                        System.out.println("===" + list + "===");
                        boolean isEqual = false;
                        int resultSize = result.size();
                        if (resultSize > 0) {
                            for (int m = 0; m < resultSize; m++) {
                                List<Integer> listFromResult = result.get(m);
                                if (compare(list, listFromResult)) {
                                    isEqual = true;
                                    break;
                                }
                            }
                        }
                        if (!isEqual) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean compare(List<Integer> list1, List<Integer> list2) {
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        if (list1.get(0).equals(list2.get(0)) && list1.get(1).equals(list2.get(1)) && list1.get(2).equals(list2.get(2))) {
            return true;
        }
        return false;
    }
}