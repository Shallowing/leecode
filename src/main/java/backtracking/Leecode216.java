package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leecode216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,0,1);
        return result;
    }

    private void backtracking(int k, int n, int sum, int startIndex) {
        // 剪枝操作
        if (sum>n)  return;
        if (path.size()==k && sum==n){
            result.add(new ArrayList<>(path));
            return;
        }
        // 含剪枝
        for (int i = startIndex; i <= 9-(k- path.size())+1; i++) {
            path.add(i);
            backtracking(k,n,sum+i,i+1);
            path.removeLast();
        }
    }
}
