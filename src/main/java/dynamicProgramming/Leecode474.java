package dynamicProgramming;

import org.junit.Test;

public class Leecode474 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][]dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String str : strs) {
            int number0 = 0;
            int number1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)=='0') number0++;
                if (str.charAt(i)=='1') number1++;
            }
            for (int i = m; i >= number0; i--) {
                for (int j = n; j >=number1 ; j--) {
                    dp[i][j] = Math.max(dp[i-number0][j-number1]+1,dp[i][j]);
                }
            }
        }
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String[] strs = {"10","0001","111001","1","0"};
        findMaxForm(strs,5,3);
    }
}
