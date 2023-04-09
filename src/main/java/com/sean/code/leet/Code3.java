package com.sean.code.leet;
import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Code3 {
    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charIndex = new HashMap<>();
            int maxLen = 0;
            int len = s.length();
            int start = 0, end = 0;
            while (end < len) {
                char item = s.charAt(end);
                if (charIndex.containsKey(item)) {
                    int index = charIndex.get(item);
                    if (index > start) {
                        maxLen = Math.max(maxLen, end - start);
                        start = charIndex.get(item) + 1;
                    }
                }
                charIndex.put(item, end);
                end ++;
            }

            return Math.max(maxLen, end - start);
        }
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(Solution.lengthOfLongestSubstring(s));

    }
}
