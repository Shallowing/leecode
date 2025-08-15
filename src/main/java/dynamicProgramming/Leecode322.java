package dynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

public class Leecode322 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
//        for (int i = 0; i <= amount; i++) {
//            System.out.print(dp[i] + " ");
//        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    @Test
    public void test(){
        int[] coins = {2};
        coinChange(coins,3);
    }
}
