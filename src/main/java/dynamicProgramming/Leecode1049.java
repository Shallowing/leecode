package dynamicProgramming;

import java.util.Arrays;

public class Leecode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum/2;
        int len = stones.length;
        int[] dp = new int[target+1];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j-stone] + stone);
            }
        }
        return sum-dp[target]-dp[target];
    }
}
