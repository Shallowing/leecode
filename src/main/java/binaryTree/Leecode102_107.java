package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode102_107 extends BinaryTreeUtils{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //lo1(root);
        lo2(root,0);
        return res;
    }

    /**
     * 层序遍历 递归法
     * @param root
     * @param deep
     */
    private void lo2(TreeNode root, int deep) {
        if (root == null) return;
        deep++; // 记录层数
        if (res.size()<deep){ // 给res添加元素个数
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        // 保存同一层的结点
        res.get(deep-1).add(root.val);
        // 每一层的所有结点通过递归保存它的左右孩子两个结点
        lo2(root.left,deep);
        lo2(root.right,deep);
    }
    /**
     * 层序遍历 迭代法
     * @param root
     */
    private void lo1(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 加入根节点
        while (!queue.isEmpty()){
            int size = queue.size();    // 记录每一层的结点个数
            List<Integer> list = new ArrayList<>();   // 保存同一层的所有结点
            while (size>0){
                TreeNode node = queue.remove();// 弹出头结点并保存它
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }
            res.add(list);
        }
    }
    /**
     * 层序遍历II
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //lob1(root);
        lob2(root,0);
        return res.reversed();
    }
    private void lob1(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 先加入根节点
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size(); // 保存每一个深度的结点数量
            while (size > 0){
                TreeNode node = queue.remove(); // 弹出结点
                list.add(node.val);
                // 加入弹出结点的左右子结点
                if(node.left!= null) queue.add(node.left);
                if(node.right!= null) queue.add(node.right);
                size--;
            }
            res.addFirst(list);
        }
    }
    public void lob2(TreeNode root, Integer deep){
        if (root == null)   return;
        deep++; //当前层数(深度从0开始)
        //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
        if (res.size()<deep){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(deep-1).add(root.val);
        lob2(root.left,deep);
        lob2(root.right,deep);
    }



}
