package binaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class Leecode501 extends BinaryTreeUtils{
    /**
     * 最简单的思路，用一个map存所有节点的值以及出现的次数
     */
    Map<Integer,Integer> ans = new HashMap<>();
    public int[] findMode1(TreeNode root) {
        if (root==null) return null;
        fun(root);
        // 找出最大 value
        int maxValue = ans.values().stream()
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        List<Integer> list = ans.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void fun(TreeNode root) {
        if (root==null) return;
        fun(root.left);
        ans.put(root.val,ans.getOrDefault(root.val,0)+1) ;
        fun(root.right);
    }

    /**
     * 不使用额外空间
     * @param root
     * @return
     */
    List<Integer> ans1 = new ArrayList<>();
    TreeNode pre = null;
    int count = 1,max =0;
    public int[] findMode(TreeNode root) {
        fun2(root);
        return ans1.stream().mapToInt(Integer::intValue).toArray();
    }

    private void fun2(TreeNode root) {
        if (root==null) return;
        fun2(root.left);
        // 这一步将count还原成1
        if (pre==null || pre.val!= root.val) {
            count=1;
        }else count++;
        // 更新结果
        if (count>max) {
            // 这一步clear是关键，达到了不断刷新的效果
            ans1.clear();
            ans1.add(root.val);
            max=count;
        } else if (count==max) {
            ans1.add(root.val);
        }
        pre =root;
        fun2(root.right);
    }
}
