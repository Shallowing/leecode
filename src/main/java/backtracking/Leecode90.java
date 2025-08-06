package backtracking;

import org.junit.Test;

import java.util.*;

public class Leecode90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 要先排序
        Arrays.sort(nums);
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length) return;
        Set<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }

    }
    @Test
    public void test(){
        int[] nums = {4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }
}
