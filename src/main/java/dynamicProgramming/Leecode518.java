package dynamicProgramming;

import org.junit.Test;

public class Leecode518 {
    public int change(int amount, int[] coins) {
        //递推表达式
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                dp[j] += dp[j - coins[i]];
//                System.out.print(dp[j] + " ");
//            }
//        }
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }

        }
        return dp[amount];
    }
    public int change1(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        // 初始化边界值
        for(int i = 0; i < coins.length; i++){
            // 第一列的初始值为1
            dp[i][0] = 1;
        }
        for(int j = coins[0]; j <= amount; j++){
            // 初始化第一行
            dp[0][j] += dp[0][j-coins[0]];
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
            }
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[coins.length-1][amount];
    }

    @Test
    public void test(){
        int[] coins = {1,2,5};
        int amount = 5;
        change(5,coins);
    }
}
