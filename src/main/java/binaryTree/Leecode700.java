
package binaryTree;

public class Leecode700 extends BinaryTreeUtils{
    public TreeNode searchBST(TreeNode root, int val) {
//        return DFS(root,val);
        return BFS(root,val);
    }

    private TreeNode BFS(TreeNode root, int val) {
        while (root!=null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) {
                root = root.right;
            } else return root;
        }
        return null;
    }

    private TreeNode DFS(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode node = null;
        if (val<root.val)  node= DFS(root.left,val);
        if (val>root.val) node = DFS(root.right,val);
        return node;
    }
}
