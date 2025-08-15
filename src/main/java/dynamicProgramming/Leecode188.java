package dynamicProgramming;

public class Leecode188 {
    public int maxProfit1(int k, int[] prices) {
        int len = prices.length;
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int [][] dp = new int[len][2*k+1];
        // dp数组的初始化
        for (int i = 1; i < k*2; i+=2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k*2 -1; j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j]-prices[i]);
                dp[i][j+2] = Math.max(dp[i-1][j+2], dp[i-1][j+1]+prices[i]);
            }
        }
        return dp[len-1][2*k];
    }

    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[k*2+1];
        // 初始化
        for (int i = 1; i < k*2+1; i+=2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {//i 從 1 開始，因爲第 i = 0 天已經透過初始化完成了。
            for (int j = 1; j < 2*k+1; j++) {
                // 奇数买入
                if (j%2 == 1) dp[j] = Math.max(dp[j],dp[j-1]-prices[i]);
                else dp[j] = Math.max(dp[j],dp[j-1] + prices[i]);
            }
        }
        return dp[2*k];
    }
}
