package greedy;

public class Leecode55 {
    /**
     * 跳跃游戏55
     * 维持一个最大的覆盖范围, 只能在覆盖范围内遍历(i <= cover)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover ; i++) {
            cover = Math.max(cover,i+nums[i]);
            if (cover>=nums.length-1) return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int cover = 0, count=0, next=0;
        int cur = 0;
        for (int i = cur; i <= cover ; i++) {
            next = Math.max(next,i+nums[i]);
            if (i==cover) {
                cur = cover;
                cover = next;
                count++;
            }
            if (cover>=nums.length-1) break;
        }
        return count;
    }
}
