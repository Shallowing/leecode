package binaryTree;

public class Leecode108 extends BinaryTreeUtils{
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedHelper(nums,0,nums.length);
    }

    private TreeNode sortedHelper(int[] nums, int begin, int end) {
        if (begin>=end) return null;
        // 找到根结点索引位置
        int midIndex = begin + (end-begin)/2;
        // 创建根节点
        TreeNode root = new TreeNode(nums[midIndex]);
        // 构建左子树
        root.left = sortedHelper(nums, begin, midIndex);
        // 构建右子树
        root.right = sortedHelper(nums, midIndex + 1, end);

        return root;
    }
}
