package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode199 extends BinaryTreeUtils{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.remove();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
                // 保存每一层的最后一个结点即可
                if (size==0) res.add(node.val);
            }
        }
        return res;
    }

    /**
     * 二叉树的平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levelSum += node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(levelSum/size);
        }
        return res;
    }

    @Test
    public void test(){
        Integer[] values = {1,2,3,4,null,null,null,5};
        TreeNode treeNode = buildTree(values);

        System.out.println(rightSideView(treeNode));


    }
}
