package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Leecode113 extends BinaryTreeUtils{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPath(result,path,root,targetSum);
        return result;
    }

    private void getPath(List<List<Integer>> result, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        // 遇到叶子结点
        if (root.left==null && root.right==null && targetSum==root.val){
            // result.add(path);
            result.add(new ArrayList<>(path));
        }
        if (root.left!=null){
            getPath(result,path,root.left,targetSum-root.val);
            path.removeLast();
        }
        if (root.right!=null){
            getPath(result,path,root.right,targetSum-root.val);
            path.removeLast();
        }
    }
}
