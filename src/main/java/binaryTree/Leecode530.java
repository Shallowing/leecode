package binaryTree;

public class Leecode530 extends BinaryTreeUtils{
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root==null) return 0;
        getMinimumDifference(root.left);
        if (pre!=null) min = Math.min(root.val-pre.val,min);
        pre = root;
        getMinimumDifference(root.right);
        return min;
    }

}
