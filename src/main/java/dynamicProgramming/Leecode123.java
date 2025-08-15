package dynamicProgramming;

public class Leecode123 {

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }
        return dp[len-1][4];
    }

    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        // dp[0]代表第一次持有
        dp[0] = -prices[0];
        // dp[1]代表第一次未持有
        dp[1] = 0;
        // dp[2]代表第二次持有
        dp[2] = -prices[0];
        // dp[3]代表第二次未持有
        dp[3] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0],-prices[i-1]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2],dp[1] - prices[i-1]);
            dp[3] = Math.max(dp[3],dp[2] + prices[i-1]);
        }
        return dp[3];
    }
}
