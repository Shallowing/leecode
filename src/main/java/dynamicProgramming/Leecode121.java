package dynamicProgramming;

public class Leecode121 {
    /**
     * 使用二维dp数组
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i],dp[i-1][1]);
        }
        return dp[len-1][1];
    }
    /**
     * 优化二维dp数组
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i%2][0] = Math.max(dp[(i-1)%2][0], -prices[i]);
            dp[i%2][1] = Math.max(dp[(i-1)%2][0] + prices[i],dp[(i-1)%2][1]);
        }
        return dp[(len-1)%2][1];
    }

    /**
     * 使用一维dp数组
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        // 记录一次交易，一次交易有买入卖出两种状态
        // 0代表持有，1代表卖出
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            // 前一天持有；或当天买入
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            // 如果 dp[0] 被更新，那么 dp[1] 肯定会被更新为正数的 dp[1]
            // 而不是 dp[0]+prices[i-1]==0 的0，
            // 所以这里使用会改变的dp[0]也是可以的
            // 当然 dp[1] 初始值为 0 ，被更新成 0 也没影响
            // 前一天卖出；或当天卖出, 当天要卖出，得前一天持有才行
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
        }
        return dp[1];
    }




}
