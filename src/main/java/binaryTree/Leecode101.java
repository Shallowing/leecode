package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class Leecode101 extends BinaryTreeUtils{
    /**
     * 递归法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return compareNode(root.left,root.right);
    }

    private boolean compareNode(TreeNode left, TreeNode right) {
        if (left==null && right!=null) return false;
        else if (left!=null && right==null) return false;
        else if (left==null && right==null) return true;
        else if (left.val!=right.val) return false;
        boolean compare1 = compareNode(left.left, right.right);
        boolean compare2 = compareNode(left.right, right.left);
        return compare1&&compare2;

    }

    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
}
