package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode116 extends BinaryTreeUtils{
    /**
     * 层序遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                node.next = i==size-1 ?null:queue.peek();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }



}
