package dynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

public class Leecode416 {
    /**
     * 二维数组做法
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 和为奇数则不满足条件
        if ((sum%2) != 0) return false;
//        Arrays.sort(nums);  不需要排序

        int target = sum/2; // 实际背包的容量
        int len = nums.length; // 物品的个数
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        /*
        dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数
          每个数只能用一次，使得这些数的和恰好等于 j。
        */
        int[][] dp = new int[len][target+1]; // 背包要取到target，所以是target+1
        // 初始化第0行
        for (int i = 0; i <= target; i++) {
            if (i>=nums[0]) dp[0][i] = nums[0];
        }
        /*
        // 初始化列,不用做
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        */
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[len-1][target]);
        return dp[len-1][target] == target;
    }

    /**
     * 一维数组做法
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 和为奇数则不满足条件
        if ((sum%2) != 0) return false;
        int len = nums.length;
        int target = sum/2;
        int[] dp = new int[target+1];
//        dp[0] = 0; // 这一步初始化不用做默认为0
        for (int i = 0; i < len; i++) {
            // j>=nums[i],只改变背包容量不小于当前物品重量的背包，小于的背包值不变
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target]==target;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,5};
        canPartition(nums);
    }
}
