package dynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i*i <= n ; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-i*i]+1,dp[j]);
                }

            }
        }
//        System.out.println(list);
//        for (int i = 0; i <= n; i++) {
//            System.out.print(dp[i] + " ");
//        }

        return dp[n];
    }
    @Test
    public void test(){
        numSquares(12);
    }
}
