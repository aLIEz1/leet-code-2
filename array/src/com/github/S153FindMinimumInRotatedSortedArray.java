package com.github;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author ZhangFuQi
 * @date 2021/8/6 21:41
 */
public class S153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new S153FindMinimumInRotatedSortedArray().findMin(new int[]{3, 1, 2}));
    }
}
