package com.sean.code.leet.array;

import java.util.Arrays;

/**
 *给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * n*m = (n-1) * K + sum(nums)  m >= max
 * 因为k有复杂的约束条件，正想不太好求解
 *
 * sum(nums) - K = n*m - n * K
 * sum(nums) - K = n*(m -K)
 * 最小值每次都必须要 +1, 否则不会达到最大相同值，所以 m-k = min（nums）
 * sum(nums) - K = n* min(nums)
 * K = sum(nums) - n * min(nums)
 *
 */
public class Code453 {
    public static int minMoves(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int k = 0;
        for (int element: nums) {
            k += element - min;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100, 0 ,100};
        int k = minMoves(nums);
        System.out.println(k);
    }

}
