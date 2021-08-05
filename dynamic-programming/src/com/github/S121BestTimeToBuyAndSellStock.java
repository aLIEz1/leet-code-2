package com.github;

/**
 * 买卖股票的最佳时机
 *
 * @author ZhangFuQi
 * @date 2021/8/6 1:37
 */
public class S121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //不买入最大收益
        dp[0][0] = 0;
        //买入最大收益
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //如果当前没有买入，
            // 当前最大收益等于前一天也没有买入的收益，与前一天买入了现在又卖出了的收益之间最大的那个
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //如果当前买入了，当前最大收益等于前一天也买入了,前一天没有买入，今天刚买入的收益最大值
            //今天买入收益为-prices
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
