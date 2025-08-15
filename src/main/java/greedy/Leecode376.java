package greedy;

public class Leecode376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length==1) return 1;
        int pre = 0,cur=0,count=1;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i-1];
            if (cur>0 && pre<=0 || cur<0 && pre>=0) {
                // pre不需要实时跟着cur去变化，只在坡度有变化时记录一下坡度的方向即可
                pre = cur;
                count++;
            }

        }
        return count;
    }
}
