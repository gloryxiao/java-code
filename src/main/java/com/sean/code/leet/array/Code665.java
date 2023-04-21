package com.sean.code.leet.array;

/**
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路： 找到最小值，拿掉后是否还是一个非递减数列，拿掉的策略可以赋值为右侧元素值
 * 所以只遍历1次，找1个极小值点
 */

public class Code665 {
    public boolean checkPossibility(int[] nums) {
        if (null == nums) {
            return false;
        }
        int len = nums.length;
        if (len <= 2) {
            return true;
        }
        int n = 0;
        int ind = 0;
        for (int i = 0; i<= len - 2; i ++) {
            if (nums[i] > nums[i + 1]) {
                n ++;
                ind = i + 1;
            }
            if (n >= 2) {
                return false;
            }
        }
        if (n == 0) {
            return true;
        }
        if (ind == 1 || ind == len - 1) {
            return true;
        }
        int left = nums[ind - 1];
        int right = nums[ind + 1];
        if (right >= left) {
            return true;
        }
        int leftLeft = nums[ind - 2];
        if (leftLeft > nums[ind]) {
            return false;
        }
        return true;
    }
}
