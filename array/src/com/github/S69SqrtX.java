package com.github;

/**
 * x的平方根
 *
 * @author ZhangFuQi
 * @date 2021/8/12 21:30
 */
public class S69SqrtX {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
