package binaryTree;

import org.junit.Test;

public class Leecode106_105_654 extends BinaryTreeUtils{

    /**
     * 中序和后序构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder==null || postorder==null || inorder.length != postorder.length) return null;
//
//        return buildHelper(inorder,0,inorder.length,postorder,0,postorder.length);
//    }
//
//    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
//        if (postorderEnd == postorderStart) return null;
//        // 从后序遍历中找到根结点
//        TreeNode root = new TreeNode(postorder[postorderEnd-1]);
//        // 确定根节点在中序遍历中的索引,注意从inorderStart开始，而不是0
//        int middle;
//        for (middle = inorderStart; middle < inorderEnd; middle++) {
//            if (inorder[middle]==root.val) break;
//        }
//        // 确定左子树的和右子树中序遍历的相关索引位置
//        int leftInorderStart = inorderStart;
//        int leftInorderEnd = middle;
//        int rightInorderStart = leftInorderEnd+1;
//        int rightInorderEnd = inorderEnd;
//        // 确定左子树的和右子树后序遍历的相关索引位置
//        int leftPostorderStart = postorderStart;
//        int leftPostorderEnd = leftPostorderStart + (leftInorderEnd-leftInorderStart);
//        int rightPostorderStart = leftPostorderEnd;
//        int rightPostorderEnd = postorderEnd-1;
//        root.left = buildHelper(inorder,leftInorderStart,leftInorderEnd,postorder,leftPostorderStart,leftPostorderEnd);
//        root.right = buildHelper(inorder,rightInorderStart,rightInorderEnd,postorder,rightPostorderStart,rightPostorderEnd);
//        return root;
//    }
    /**
     * 前序和中序构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder==null || preorder==null || inorder.length != preorder.length) return null;

        return buildHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderEnd == preorderStart) return null;
        // 从前序遍历中找到根结点
        TreeNode root = new TreeNode(preorder[preorderStart]);
        // 确定根节点在中序遍历中的索引,注意从inorderStart开始，而不是0
        int middle;
        for (middle = inorderStart; middle < inorderEnd; middle++) {
            if (inorder[middle]==root.val) break;
        }
        // 确定左子树的和右子树中序遍历的相关索引位置
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middle;
        int rightInorderStart = leftInorderEnd+1;
        int rightInorderEnd = inorderEnd;
        // 确定左子树的和右子树后序遍历的相关索引位置
        int leftPreorderStart = preorderStart+1;
        int leftPreorderEnd = leftPreorderStart + (leftInorderEnd-leftInorderStart);
        int rightPreorderStart = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd;
        root.left = buildHelper(preorder,leftPreorderStart,leftPreorderEnd,inorder,leftInorderStart,leftInorderEnd);
        root.right = buildHelper(preorder,rightPreorderStart,rightPreorderEnd,inorder,rightInorderStart,rightInorderEnd);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums==null) return null;
        return buildHelperMax(nums,0,nums.length);
    }

    private TreeNode buildHelperMax(int[] nums, int start, int end) {
        if (start>=end) return null;
        // 最大值的索引
        int maxIndex= start;
        for (int i =start; i < end; i++) {
            if (nums[i]>nums[maxIndex]) maxIndex=i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        int leftStart = start, leftEnd = maxIndex;
        int rightStart = maxIndex+1, rightEnd = end;
        root.left = buildHelperMax(nums,leftStart,leftEnd);
        root.right = buildHelperMax(nums,rightStart,rightEnd);
        return root;
    }

    @Test
    public void test(){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        buildTree(inorder,postorder);

    }



}
