package com.sean.code.leet;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 */
public class Code4 {

    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int lenSum = len1 + len2;
            if (lenSum == 0) {
                return 0;
            }

            int mid = lenSum / 2;
            boolean odd = lenSum % 2 != 0;
            int start1 = 0, start2 = 0;
            int start1M = start1, start2M = start2;
            while ((start1 < len1 || start2 < len2) && mid - start1M -start2M > 0) {
                Integer item1 = null;
                if (start1 < len1) {
                    item1 = nums1[start1];
                }

                Integer item2 = null;
                if (start2 < len2) {
                    item2 = nums2[start2];
                }

                if (null == item1 ) {
                    start2 ++;
                } else if (null == item2 ) {
                    start1 ++;
                } else {
                    if (item1 < item2) {
                        if (start1 == len1 -1) {
                            start1M = len1;
                            start2 ++;
                        } else {
                            start1 ++;
                        }
                    } else {
                        if (start2 == len2) {
                            start2 ++;
                        }
                    }
                }
            }

            if (start1 == len1) {
                if (odd) {
                    return nums2[mid];
                } else {
                    return (nums2[mid] + nums2[mid -1]) / 2.0;
                }
            } else if (start2 == len2){
                if (odd) {
                    return nums1[mid];
                } else {
                    return (nums1[mid] + nums1[mid -1]) / 2.0;
                }
            } else {
                if (start1 == 0) {

                }

            }

            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
