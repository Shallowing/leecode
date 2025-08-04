package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test102 extends BinaryTreeUtils{

    // 创建一个节点用于保存最终结果
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
//        TreeNode node = helpFun(root, p, q);
        helpFun2(root,p,q);
        return ans;

    }

    private boolean helpFun2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return false;
        if (root==p || root==q) ans = root;
        boolean left = helpFun2(root.left, p, q);
        boolean right = helpFun2(root.right, p, q);
        if (left && right) ans = root;
        return left || right || root==p || root==q;
    }

    private TreeNode helpFun(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root == p || root ==q) return root;
        TreeNode left = helpFun(root.left, p, q);
        TreeNode right = helpFun(root.right, p, q);

        if (left==null && right==null) return null;
        else if (left!=null && right==null) return root.left;
        else if (left==null && right!=null) return root.right;
        else return root;
    }

}
