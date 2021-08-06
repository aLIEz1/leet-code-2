package com.github;

/**
 * 搜索旋转排序数组
 *
 * @author ZhangFuQi
 * @date 2021/8/6 20:47
 */
public class S33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return target;
            }
            //左边是有序的
            if (nums[mid] <= target && nums[0] >= target) {

            } else if (nums[mid] <= target && nums[right] >= target) {

            }
        }
        return -1;
    }
}
