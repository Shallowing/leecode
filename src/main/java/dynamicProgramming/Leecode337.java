package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Leecode337 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * 动态规划
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        int[] res = fun(root);
        return Math.max(res[0], res[1]);
    }
    // 当前根节点不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    private int[] fun(TreeNode root) {
      int[] res = new int[2];
      if (root==null)  return res;
      int[] left = fun(root.left);
      int[] right = fun(root.right);
      res[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
      res[1] = root.val + left[0] + right[0];
      return res;
    }

    /**
     * 递归暴力解法
     * @param root
     * @return
     */
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int money = root.val;
//        if (root.left != null){
//            money += rob(root.left.left) + rob(root.left.right);
//        }
//        if (root.right != null){
//            money += rob(root.right.left) + rob(root.right.right);
//        }
//        return Math.max(money,rob(root.left)+rob(root.right));
//    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robHelper(root,memo);
    }

    private int robHelper(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if (root.left != null){
            money += robHelper(root.left.left,memo) + robHelper(root.left.right,memo);
        }
        if (root.right != null){
            money += robHelper(root.right.left,memo) + robHelper(root.right.right,memo);
        }
        int result = Math.max(money,robHelper(root.left,memo)+robHelper(root.right,memo));
        memo.put(root,result);
        return result;
    }
}
