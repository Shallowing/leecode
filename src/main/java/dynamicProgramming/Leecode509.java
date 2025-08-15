package dynamicProgramming;

import org.junit.Test;

public class Leecode509 {
    public int fib(int n) {
        // 防止n=0时，初始化dp[1]越界
        if (n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
        return dp[n];
    }
    public int fib1(int n) {
        if (n<2) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <=n ; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
    @Test
    public void test(){
        fib(25);
    }
}
