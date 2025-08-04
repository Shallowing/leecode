package binaryTree;

public class Leecode110 extends BinaryTreeUtils{
    /**
     * 递归法
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    private int getHeight(TreeNode node) {
        if (node==null) return 0;
        // 子树都不为平衡二叉树，则整棵树不为平衡二叉树
        int leftLever = getHeight(node.left);
        if (leftLever == -1) return -1;
        int rightLever = getHeight(node.right);
        if (rightLever == -1) return -1;
        // 如果左右孩子结点的高度差大于1，返回-1，标志不为平衡二叉树
        if (Math.abs(leftLever-rightLever)>1) return -1;
        return Math.max(leftLever,rightLever)+1;
    }
}
