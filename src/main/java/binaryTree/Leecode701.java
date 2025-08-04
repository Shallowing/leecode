package binaryTree;

public class Leecode701 extends BinaryTreeUtils{
    /**
     * 迭代法
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode savaRoot = root;
        TreeNode pre = root;
        while (root!=null){
            pre = root;
            if (root.val>val) root=root.left;
            else if (root.val<val) root=root.right;
        }
        if (pre.val>val) pre.left = new TreeNode(val);
        if (pre.val<val) pre.right = new TreeNode(val);
        return savaRoot;
    }

    /**
     * 递归法
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root==null) return new TreeNode(val);
        if (root.val>val) root.left=insertIntoBST(root.left,val);
        else if (root.val<val) root.right=insertIntoBST(root.right,val);

        return root;
    }
}
