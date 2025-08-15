package dynamicProgramming;

import java.util.Arrays;

public class Leecode62_63 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行
        Arrays.fill(dp[0],1);
        // 初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        // 初始化第一行，障碍之后的元素全为0
        for (int i = 0; i < col && obstacleGrid[0][i]==0; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列，障碍之后的元素全为0
        for (int i = 0; i < row && obstacleGrid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 障碍的地方不进行计算，值为0，说明有0条路径到达
                if (obstacleGrid[i][j] ==0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
