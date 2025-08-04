package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leecode404 extends BinaryTreeUtils{
    /**
     * 层序遍历法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left!=null && node.left.left==null&&node.left.right==null) sum += node.left.val;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return sum;
    }


    /**
     * 递归法
     * @param root
     * @return
     */
    // 全局变量存放累加的左叶子节点之和
    int sum = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 0;
        // 满足下列条件，该节点的左子节点即是左叶子节点
        if (root.left!=null&&root.left.left==null&&root.left.right==null) sum += root.left.val;
        sumOfLeftLeaves1(root.left); // 遍历左子树
        sumOfLeftLeaves1(root.right); // 遍历右子树
        return sum;
    }
}
