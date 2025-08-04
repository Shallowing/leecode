package binaryTree;

public class Leecode236 extends BinaryTreeUtils{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null && right==null) return null;
        else if (left==null && right!=null) return right;
        else if (left!=null && right==null) return left;
        return root;
    }

    /**
     * 分开考虑最近公共祖先节点为节点本身的情况
     */
    private TreeNode ans;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if((rson && lson) || (root == q || root == p)){
            ans = root;
        }
        return lson || rson || root == q || root == p;
    }
}
