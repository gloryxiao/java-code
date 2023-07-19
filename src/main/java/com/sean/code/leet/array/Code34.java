package com.sean.code.leet.array;

public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int location = binSearch(nums, 0, len - 1, target);
        if (location == -1) {
            return new int[] {-1, -1};
        } else {
            int start = location;
            int end = location;
            while(start >= 0 && nums[start] == target) {
                start --;
            }
            while(end <= len - 1 && nums[end] ==target) {
                end ++;
            }
            return new int[] {start + 1, end - 1};
        }
    }

    public int[] searchRange1(int[] nums, int target) {
        int len = nums.length;
        int left = binSearch(nums, 0, len - 1, target, true);
        int right = binSearch(nums, 0, len - 1, target, false) - 1;
        if (left < right && left >= 0 && right <= len - 1 && nums[left] == target && nums[right] == target) {
            return new int[] {left, right};
        } else {
            return new int[] {-1, -1};
        }
    }

    public int binSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binSearch(nums, mid + 1, end, target);
        } else {
            return binSearch(nums, start, mid - 1, target);
        }
    }

    public int binSearch(int[] nums, int start, int end, int target, boolean lower) {
        if (start >= end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (lower) {
            if (nums[mid] >= target) {
                return binSearch(nums, start, mid - 1, target, lower);
            } else {
                return binSearch(nums, mid + 1, end, target, lower);
            }
        } else {
            if (nums[mid] <= target) {
                return binSearch(nums, mid + 1, end, target, lower);
            } else {
                return binSearch(nums, start, mid - 1, target, lower);
            }
        }
    }

}
