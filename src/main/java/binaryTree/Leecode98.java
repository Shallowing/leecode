package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leecode98 extends BinaryTreeUtils{
    List<Integer> vals = new LinkedList<>();
    /**
     * 中序遍历二叉搜索树，是严格递增的
     * 用一个list保存搜索的结果，然后判读它是否递增。
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root==null) return true;
        DFS(root);
        // 判断list是否递增
        for (int i = 1; i < vals.size(); i++) {
            if (vals.get(i)<=vals.get(i-1)) return false;
        }
        return true;
    }
    private void DFS(TreeNode root) {
        if (root==null) return;
        DFS(root.left);
        vals.add(root.val);
        DFS(root.right);
    }

    /**
     * 利用一个node保存中序遍历的前一个节点
     * 这样就不用定义一个全局的最小值
     */
    TreeNode node = null;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;

        boolean left = isValidBST(root.left);
        if (node!=null && node.val>=root.val) return false;
        node = root;
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}
