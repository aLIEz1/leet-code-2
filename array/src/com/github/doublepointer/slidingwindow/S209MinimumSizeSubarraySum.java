package com.github.doublepointer.slidingwindow;

/**
 * 长度最小的子数组
 *
 * @author ZhangFuQi
 * @date 2021/8/1 22:21
 */
public class S209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (right < nums.length) {
            //窗口增长
            int rightSideView = nums[right];
            right++;
            if (sum < target) {
                sum += rightSideView;
            }
            //窗口缩小，取最优解
            while (sum >= target) {
                length = Math.min(right - left, length);
                int leftSideView = nums[left];
                left++;
                sum -= leftSideView;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
