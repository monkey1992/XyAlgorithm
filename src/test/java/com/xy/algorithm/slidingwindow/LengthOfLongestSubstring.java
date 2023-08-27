package com.xy.algorithm.slidingwindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口系列
 * 无重复字符的最长子串
 * <p>
 * LeetCode地址：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * <p>
 * 题目描述：
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    @Test
    public void testLengthOfLongestSubstring() {
        String[] strings = new String[]{
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "aabaab!bb",
                "dvdf"
        };
        for (String s : strings) {
            long timestamp = System.nanoTime();
            int maxLength = practice(s);
//            int maxLength = mySolution(s);
//            int maxLength = lengthOfLongestSubstring1(s);
//            int maxLength = lengthOfLongestSubstring2(s);
            System.out.println("maxLength: " + maxLength + "，耗时：" + (System.nanoTime() - timestamp) + " 纳秒");
        }
    }

    /**
     * 练习
     */
    private int practice(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return length;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);
            Integer position = map.get(c);
            if (position != null) {
                left = Math.max(left, position + 1);
            }
            map.put(c, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    /**
     * 我的题解
     */
    private int mySolution(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int maxLength = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (list.contains(c)) {
                int size = list.size();
                if (size > maxLength) {
                    maxLength = size;
                }
                int index = list.indexOf(c);
                list = list.subList(index + 1, size);
                list.add(c);
            } else {
                list.add(c);
                int size = list.size();
                if (size > maxLength) {
                    maxLength = size;
                }
            }
        }
        return maxLength;
    }

    /**
     * 优秀题解1
     */
    private int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < length; right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }

    /**
     * 优秀题解2
     */
    private int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int result = 0;
        int[] charIndex = new int[256];
        for (int left = 0, right = 0; right < length; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }
        return result;
    }
}