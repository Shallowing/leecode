package linkedList;

import org.junit.Test;

public class Leecode24 extends LinkedListUtils{

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode dummyNode = new ListNode(-1,head);
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next; // 保存结点1
            ListNode node2 = cur.next.next; // 保存结点2
            cur.next = node2;
            node1.next = node2.next;    // 需要先做这步交换，不然会丢失结点3的连接
            node2.next = node1;
            // 移动两个位置
            cur = cur.next.next;
        }
        // 返回头结点（非哨兵结点）
        return dummyNode.next;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        // base case 退出提交
        // 注意head.next == null要写在前面，不然如果head=null，会报空指针异常
        // 退出条件，当前结点为空，或者只有一个结点。
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归，获取第三个结点
        ListNode newNode = swapPairs2(next.next);
        // 这里进行交换，1,2,3个结点进行交换
        next.next = head;
        head.next = newNode;
        return next;
    }

    @Test
    public void test(){
        int[] values = {1,2,3,4};
        int[] values1 = {1,2,3,4,5};
        ListNode listNode = newLinkedList(values1);
        printList(listNode);
        ListNode swap = swapPairs2(listNode);
        printList(swap);
    }

}
