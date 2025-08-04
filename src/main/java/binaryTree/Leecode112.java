package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Leecode112 extends BinaryTreeUtils{
    List<Integer> Pathsum = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> paths = new ArrayList<>();
        getPaths(paths,root);
        return Pathsum.contains(targetSum);
    }

    /**
     * 求出所有的路径之和
     * @param paths
     * @param root
     */
    private void getPaths(List<Integer> paths, TreeNode root) {
        if (root==null) return;
        paths.add(root.val);
        if (root.left==null&&root.right==null){
            int sum=0;
            for (Integer path : paths) {
                sum+=path;
            }
            Pathsum.add(sum);
            return;
        }
        if (root.left!=null){
            getPaths(paths,root.left);
            // 注意回溯的位置
            paths.removeLast();
        }
        if (root.right!=null){
            getPaths(paths,root.right);
            paths.removeLast();
        }
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root==null) return false;
        if (root.left==null && root.right==null){
            // 传入的targetSum为包含当前结点路径的总和，不能写成targetSum==0；
            return targetSum==root.val;
        }
        if (root.left!=null){
            if (hasPathSum1(root.left,targetSum-root.val)) return true;
        }
        if (root.right!=null){
            if (hasPathSum1(root.right,targetSum-root.val)) return true;
        }
        return false;
    }
}
