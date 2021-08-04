package com.github.doublepointer;

/**
 * 二分查找
 * 注意left和right一开始的取值，right能不能取到
 * 能取到while循环中就能等于，不能取到while循环中就不能等于
 * 能取到右边可以等于mid-1,因为除去了mid,不能取到右边要等于mid因为mid取不到，小于相当于取了mid-1;
 *
 * @author ZhangFuQi
 * @date 2021/8/1 20:31
 */
public class S704BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
