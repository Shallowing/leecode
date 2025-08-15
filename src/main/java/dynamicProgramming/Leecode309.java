package dynamicProgramming;

public class Leecode309 {
    /**
     * 二维dp数组
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1]-prices[i],dp[i-1][3]-prices[i]));
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2] ;
        }
        return Math.max(Math.max(dp[len-1][1],dp[len-1][2]),dp[len-1][3]);
    }

    /**
     * 一维dp数组
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];

        dp[0] = -prices[0];
        for(int i = 1; i <= prices.length; i++){
            // 使用临时变量来保存dp[0], dp[2]
            // 因为马上dp[0]和dp[2]的数据都会变
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i-1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i-1];
            dp[3] = temp1;
        }
        return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }
}
