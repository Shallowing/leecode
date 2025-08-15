package dynamicProgramming;

import java.util.Arrays;

public class Leecode674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i]>nums[i-1]) dp[i] = dp[i-1]+1;
            if (dp[i]>result) result = dp[i];
        }
        return result;
    }
}
