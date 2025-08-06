package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leecode77 {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    // 存放符合条件的结果
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    // startIndex来记录下一层递归，搜索的起始位置
    // 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
    private void backtracking(int n, int k, int startIndex) {
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <=n-(k-path.size())+1 ; i++) {
            path.add(i);  // 处理结点
            backtracking(n,k,i+1);
            path.removeLast(); // 回溯
        }
    }
}
