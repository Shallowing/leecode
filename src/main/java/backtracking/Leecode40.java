package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leecode40 {
    /**
     * 使用used数组
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[]used = new boolean[candidates.length];
//        backtracking(candidates,target,0,0);
        backtracking(candidates,target,0,0,used);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        if (sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 去重，当used[i-1] = true 时，证明现在是在下一层，为false才是在同一层
            if (i>0 && candidates[i]==candidates[i-1] && !used[i-1]) continue;
            if (sum+candidates[i]>target) break;
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates,target,sum+candidates[i],i+1,used);
            used[i] = false;
            path.removeLast();
        }
    }

//    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
//        if (sum>target) return;
//        if (sum==target){
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++) {
//            //正确剔除重复解的办法
//            //跳过同一树层使用过的元素
//            if (i>startIndex && candidates[i]==candidates[i-1]) continue;
//            if (sum+candidates[i]>target) break;
//            path.add(candidates[i]);
//            backtracking(candidates,target,sum+candidates[i],i+1);
//            path.removeLast();
//        }
//    }

}
