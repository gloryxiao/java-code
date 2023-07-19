package com.sean.base.unit.leetcn;

import com.sean.code.leet.array.Code34;
import org.junit.Assert;
import org.junit.Test;

public class Code34Test {
    @Test
    public void test() {
        Code34 code34 = new Code34();
        int[] nums = new int[] {5,7,7,8,8,10};
        int target = 8;
        int[] result = code34.searchRange(nums, target);
        int[] r2 = code34.searchRange1(nums, target);
        Assert.assertEquals(result, r2);
    }
}
