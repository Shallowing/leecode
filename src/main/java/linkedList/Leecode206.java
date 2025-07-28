package linkedList;

import org.junit.Test;

public class Leecode206 extends LinkedListUtils {
    /**
     * 双指针解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        // 用来记录当前要反转的结点
        ListNode cur = head;
        // 用来记录当前要反转结点的前一结点
        ListNode pre = null;
        while (cur != null){
            // 临时结点，用来保存当前要反转结点的后一结点
            ListNode temp = cur.next;
            // 反转结点
            cur.next = pre;
            // 移动双指针
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 初始化
        return reverse(head,null);
    }
    public ListNode reverse(ListNode cur,ListNode pre){
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp,cur);
    }
    @Test
    public void test(){
        int[] values = {1,2,3,4,5};
        ListNode listNode = newLinkedList(values);
        printList(listNode);
        ListNode reversedList = reverseList2(listNode.next.next);
        printList(reversedList);
        printList(listNode);
        ListNode listNode1 = reverseList2(reversedList);
        printList(listNode1);
        printList(listNode);
    }

}
