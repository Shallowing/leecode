package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leecode104_111 extends BinaryTreeUtils {
    /**
     * 二叉树的最大深度 104
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        int maxDepth = max1(root);
        int maxDepth = max2(root);

        return maxDepth;
    }
    /**
     * 递归法
     * @param root
     * @return
     */
    private int max2(TreeNode root) {
        if (root==null) return 0;
        int leftDepth = max2(root.left);
        int rightDepth = max2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    /**
     * 迭代法（层序遍历）
     * @param root
     * @return
     */
    private int max1(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            max++;
        }
        return max;
    }

    /**
     * 二叉树的最小深度 111
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
//        int min = min1(root);
        int min = min2(root);
        return min;
    }
    /**
     * 递归法
     * @param root
     * @return
     */
    private int min2(TreeNode root) {
        if (root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if (root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.max(m1, m2) + 1;
    }
    /**
     * 迭代法（层序遍历）
     * @param root
     * @return
     */
    private int min1(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left==null && node.right==null) return min;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return min;
    }

}

