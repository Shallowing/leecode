package binaryTree;

public class Leecode513 extends BinaryTreeUtils{

    /**
     * 递归法
     */
    int maxDeepth = -1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {

        findValue(root,1);
        return res;
    }

    private void findValue(TreeNode root, int deepth) {
        if (root==null) return;
        // 当遇到叶子结点时，才判断深度值，如果更深则更新res值
        if (root.left==null&&root.right==null) {
            if (deepth > maxDeepth) {
                maxDeepth = deepth;
                res = root.val;
                return;
            }
        }
        if (root.left!=null){
            findValue(root.left,deepth+1);
        }
        if (root.right!=null){
            findValue(root.right,deepth+1);
        }
    }
}
