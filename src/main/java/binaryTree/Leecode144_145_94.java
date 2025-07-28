package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leecode144_145_94 extends BinaryTreeUtils{
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val); // 添加中间结点
        preorder(root.left,res);    // 添加
        preorder(root.right,res);
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }


    @Test
    public void test(){
        Integer[] values = {1,null,2,3};
        TreeNode treeNode = buildTree(values);
        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);
    }


}
