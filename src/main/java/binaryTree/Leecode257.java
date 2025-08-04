package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leecode257 extends BinaryTreeUtils{

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPaths(res,path,root);
        return res;
    }

    /**
     * 递归法
     * @param res
     * @param path
     * @param root
     */
    private void getPaths(List<String> res,List<Integer> path,TreeNode root) {
        if (root==null) return;
        // 加入父节点
        path.add(root.val);
        // 遇到叶子结点，表明有一条路径
        if (root.left==null&&root.right==null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuilder.append(path.get(i)).append("->");
            }
            // 添加最后一个节点
            stringBuilder.append(path.getLast());
            res.add(stringBuilder.toString());
            return;
        }
        // 搜索左子树，完成一条路径后需要向上回溯一个结点，才能继续搜索右子树。
        if (root.left!=null) {
            getPaths(res,path,root.left);
            // 能到这步，说明已经得到一条路径，需要向上回溯一个结点才能继续所有其他路径
            path.removeLast();
        }
        if (root.right!=null) {
            getPaths(res,path,root.right);
            // 能到这步，说明已经得到一条路径，需要向上回溯一个结点才能继续所有其他路径
            path.removeLast();
        }
    }

    @Test
    public void test(){
        Integer[] values = {1,2,3,null,5};
        TreeNode treeNode = buildTree(values);
        List<String> strings = binaryTreePaths(treeNode);
        System.out.println(strings);
    }
}
