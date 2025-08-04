package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leecode226 extends BinaryTreeUtils{
    /**
     * 翻转二叉树 递归法（前序遍历）
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    /**
     * 层序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                swapTreeNode(node);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }
//    不能这样交换左右结点的位置，要通过父节点进行交换
//    private void swapTreeNode(TreeNode left, TreeNode right) {
//        TreeNode temp = left;
//        left = right;
//        right = temp;
//
//    }
private void swapTreeNode(TreeNode node) {
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
    }
}
