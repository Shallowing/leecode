package dynamicProgramming;

import org.junit.Test;

import static java.lang.Math.max;

public class Leecode343 {
    public int integerBreak(int n) {
        if (n<2) return 0;
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                // 注意这里还要和dp[i]比较大小，选出j从1~i/2的最大dp[i]
                dp[i] = max(max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(integerBreak(10));
    }
}
