package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode46 {
//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        boolean[] used = new boolean[nums.length];
//        backtracking(nums,used);
//        return result;
//    }
//
//    private void backtracking(int[] nums, boolean[] used) {
//        if (path.size() == nums.length) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            // 如果本元素使用过了，就跳过
//            if (used[i]) continue;
//            used[i] = true;
//            path.add(nums[i]);
//            backtracking(nums,used);
//            used[i] = false;
//            path.removeLast();
//        }
//    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])) continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums);
            hs.remove(nums[i]);
            path.removeLast();
        }
    }
}
