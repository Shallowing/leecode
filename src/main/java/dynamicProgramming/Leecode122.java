package dynamicProgramming;

public class Leecode122 {

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i%2][0] = Math.max(dp[(i-1)%2][0],dp[(i-1)%2][1]-prices[i]);
            dp[i%2][1] = Math.max(dp[(i-1)%2][1],dp[(i-1)%2][0] + prices[i]);
        }
        return dp[(prices.length-1)%2][1];
    }

    public int maxProfit2(int[] prices) {
        // 0表示持有，1表示卖出
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0],dp[1]-prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }
}
