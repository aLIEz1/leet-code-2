package com.github;

/**
 * 最大子序和
 *
 * @author ZhangFuQi
 * @date 2021/8/4 23:41
 */
public class S53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            //判断要不要保留之前的pre，如果之前的pre加上现在的值比现在还小，那不如丢掉
            pre = Math.max(x + pre, x);
            //当前总值与maxAns比较，如果比maxAns大就更新maxAns的值为pre，小了就不用更新
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new S53MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
