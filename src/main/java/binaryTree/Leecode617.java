package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leecode617 extends BinaryTreeUtils{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 注意递归的结束条件
        if (root1==null) return root2;
        if (root2==null) return root1;
        TreeNode node = new TreeNode(root1.val+root2.val);
        // 两颗二叉树同时遍历
        node.left = mergeTrees(root1.left,root2.left);
        node.right = mergeTrees(root1.right,root2.right);
        return node;
    }
}
