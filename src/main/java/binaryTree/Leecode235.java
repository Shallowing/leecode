package binaryTree;

public class Leecode235 extends BinaryTreeUtils{

    /**
     * 递归法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        if (root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    /**
     * 迭代法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (root.val>p.val && root.val>q.val) root=root.left;
            else if (root.val<p.val && root.val<q.val) root=root.right;
            else break;

        }
        return root;
    }
}
