package com.github;

/**
 * 接雨水
 *
 * @author ZhangFuQi
 * @date 2021/8/7 0:26
 */
public class S42TrappingRainWater {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            for (int i1 = 0; i1 <= i; i1++) {
                left = Math.max(left, height[i1]);
            }
            int right = 0;
            for (int i2 = i; i2 < n; i2++) {
                right = Math.max(right, height[i2]);
            }
            sum += Math.min(left, right) - height[i];
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i + 1 < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        int n = height.length;

        int lMax = height[0];
        int rMax = height[n - 1];

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            //如果左边最大的小于右边（局部）最大的，直接用左边的减去就行了
            //因为我们要的是左边最大的和右边最大的较小的一个
            //只要知道左边最大的比右边的小，不管这个右边的是右边的最小的还是最大的
            // 只要取min就还是左边最大的那个
            if (lMax < rMax) {
                sum += lMax - height[left];
                left++;
            } else {
                sum += rMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
