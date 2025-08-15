package greedy;

public class Leecode53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1 ) return nums[0];
        int count = 0, sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum,count);
            // 阶段的和为负则抛弃掉
            if (count<0) count = 0;
        }
        return sum;
    }
}
