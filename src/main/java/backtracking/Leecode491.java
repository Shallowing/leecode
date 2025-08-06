package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size()>1) result.add(new ArrayList<>(path));
        // 能再次运行这行初始化代码，说明是增加了深度，即是树枝，而树枝不需要去重
        Set<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 注意是当前元素num[i]和已经保存List中的最后一个元素（最大的）相比
            // 而不是nums[i]和nums[i-1]相比
            if (!path.isEmpty() &&nums[i] < path.getLast() || hs.contains(nums[i])) continue;
            hs.add(nums[i]); // 不需要回溯，同一树层共享一个hs
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
