package binaryTree;

import static java.lang.Math.max;

public class Leecode543_124 extends BinaryTreeUtils{

    /**
     * 后序遍历
     * @param root
     * @return
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        findLength(root);
        return ans;
    }
    private int findLength(TreeNode root) {
        if (root==null) return -1; // 空节点的深度为0(return后在上一层要+1)
        if (root.left==null && root.right==null) return 0;
        // 计算左右深度
        int left = findLength(root.left)+1;
        int right = findLength(root.right)+1;
        ans = max(ans,left+right);
        // 注意返回的是左右深度的最大值
        return max(left,right);
    }

    /**
     * 最大路径和
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    private int getSum(TreeNode root) {
        if (root==null) return 0;

        int leftVal = getSum(root.left);
        int rightVal = getSum(root.right);
        maxSum = max(maxSum,leftVal+rightVal+root.val);
        // 如果当前路径值为负，则返回0，表示不选择这条路径
        return max((max(leftVal,rightVal)+root.val),0);
    }
}
