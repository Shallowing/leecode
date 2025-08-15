package dynamicProgramming;

import java.util.Arrays;

public class Leecode300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }
        int result = 0;
        for (int i : dp) {
            if (i>result) result=i;
        }
        return result;
    }
}
