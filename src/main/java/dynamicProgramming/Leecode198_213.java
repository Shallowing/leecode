package dynamicProgramming;

public class Leecode198_213 {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);
        return Math.max(rob1(nums,0,len-1),rob1(nums,1,len));
    }
    public int rob1(int[] nums,int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        int result = 0;
        for (int i = start+2; i < end; i++) {
            result = Math.max(dp[0] + nums[i],dp[1]);
            dp[0] = dp[1];
            dp[1] = result;
        }
        return dp[1];
    }
}
