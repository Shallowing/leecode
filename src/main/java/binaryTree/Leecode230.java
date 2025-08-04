package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Leecode230 extends BinaryTreeUtils{
//    List<Integer> ans = new ArrayList<>();
//    public int kthSmallest(TreeNode root, int k) {
//        helpFun(root);
//        return ans.get(k-1);
//    }
//
//    private void helpFun(TreeNode root) {
//        if (root==null) return;
//        helpFun(root.left);
//        ans.add(root.val);
//        helpFun(root.right);
//    }


    private int ans;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }
        dfs(node.left); // 左
        k--;
        if (k == 0) {
            ans = node.val; // 根
        }
        dfs(node.right); // 右
    }

}
