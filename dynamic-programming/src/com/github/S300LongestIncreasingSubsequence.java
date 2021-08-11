package com.github;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author ZhangFuQi
 * @date 2021/8/11 0:05
 */
public class S300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new S300LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
