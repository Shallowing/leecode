package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leecode39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(Arrays.stream(candidates).sorted().toArray(),target,0,0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum>target) return;
        if (sum==target){
            // 这里不是add(path)
            result.add(new ArrayList<>(path));
            return;
        }
        // 这里的i只是表示从第几个数字开始
        // 剪枝操作：sum+candidates[i]>target
        for (int i = startIndex; i < candidates.length ; i++) {
            if (sum+candidates[i]>target) break;
            // 注意这里不是add(i),而是add(candidates[i])
            path.add(candidates[i]);
            backtracking(candidates,target,sum+candidates[i],i);
            path.removeLast();
        }
    }
}
