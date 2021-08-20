package com.github;

/**
 * 缺失的第一个正数
 *
 * @author ZhangFuQi
 * @date 2021/8/14 18:48
 */
public class S41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int num : nums) {
            if (num == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int curNum = Math.abs(nums[i]);
            if (curNum <= n) {
                nums[curNum - 1] = -Math.abs(nums[curNum - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
