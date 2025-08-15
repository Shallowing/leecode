package dynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

public class Leecode494 {
    /**
     * 回溯法
     */
//    int count = 0;
//    public int findTargetSumWays(int[] nums, int target) {
//        backtraking(nums,target,0,0);
//        return count;
//    }
//    private void backtraking(int[] nums, int target, int startIndex, int sum) {
//        if (startIndex == nums.length){
//            if (sum == target) count++;
//        }else {
//            backtraking(nums,target,startIndex+1,sum+nums[startIndex]);
//            backtraking(nums,target,startIndex+1,sum-nums[startIndex]);
//        }
//    }

    /**
     * 二维dp数组
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum<Math.abs(target)) return 0;
        if (sum%2 != target%2) return 0;

        int bagTarget =  target+(sum-target)/2;
        int len = nums.length;
        int[][] dp = new int[len][bagTarget+1];

        // 只有背包容量刚好等于nums[0]的时候，才初始化为1
        if (bagTarget>=nums[0]) dp[0][nums[0]] = 1;
        int numZeros = 0;
        // 只要0~i中的物品重量为0，从此之后装满背包容量为0的方法就要乘2
        for (int i = 0; i < len; i++) {
            if (nums[i]==0) numZeros++;
            dp[i][0] = (int)Math.pow(2,numZeros);
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= bagTarget; j++) {
                if (j < nums[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= bagTarget; j++) {
                System.out.printf("%3d",dp[i][j]);
            }
            System.out.println();
        }
        System.out.println(dp[len-1][bagTarget]);
        return dp[len-1][bagTarget];
    }

    /**
     * 一维dp数组
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum<Math.abs(target)) return 0;
        if (sum%2 != target%2) return 0;
        int bagTarget =  target+(sum-target)/2;
        int[] dp = new int[bagTarget+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagTarget; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        for (int i = 0; i <= bagTarget; i++) {
            System.out.printf("%3d",dp[i]);
        }
        return dp[bagTarget];
    }
    @Test
    public void test(){
        int[] nums = new int[]{7,0,3,9,9,9,1,7,2,3};
        int target = 6;
        findTargetSumWays(nums,target);
    }


}
