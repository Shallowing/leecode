package binaryTree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leecode437 extends BinaryTreeUtils{
    /**
     * 两层递归
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum1(TreeNode root, int targetSum) {
        if (root==null) return 0;
        // 在当前结点求符合的路径
        int ret = rootSum(root,targetSum);
        // 使用递归，将左孩子当头结点进行遍历
        ret += pathSum1(root.left,targetSum);
        ret += pathSum1(root.right,targetSum);
        return ret;
    }

    /**
     * 前缀+遍历
     * @param root
     * @param targetSum
     * @return
     */
    private int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root==null) return 0;
        if (targetSum == root.val) {
            // 不return，一直遍历到叶子结点
            ret++;
        }
        ret += rootSum(root.left,targetSum-root.val);
        ret += rootSum(root.right,targetSum-root.val);
        return ret;
    }
    private Map<Long,Integer> map = new HashMap<>();
    private int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // 加入这个值是为了解决根节点为targetSum的情况
        map.put(0L, 1);
        dfs(root,0,targetSum);
        return res;
    }
    public void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return;
        }
        // 当前节点前缀和
        sum += root.val;
        // curr表示根节点到当前节点的总和，
        // curr - targetSum是查找有没有从根节点到某些结点的路径值为curr - targetSum，
        // 则从这些结点到当前结点的路径和恰好为targetSum。
        res += map.getOrDefault(sum - targetSum,0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum ,targetSum);
        // 回溯，回退节点的同时也要去掉当前路径的影响，不能影响兄弟节点
        map.put(sum, map.getOrDefault(sum, 0) - 1);

    }
    @Test
    public void test(){
        Integer[] values = new Integer[]{10,5,-3,3,2,null,11,3,-2,1};
        TreeNode node = buildTree(values);
        pathSum(node,8);
    }


}
