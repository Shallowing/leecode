package linkedList;

import org.junit.Test;

public class Leecode19 extends LinkedListUtils{
    /**
     * 利用快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1,head);
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
    @Test
    public void test(){
        int[] values = {1,2,3,4,5};
        ListNode head = newLinkedList(values);
        printList(head);
        ListNode listNode = removeNthFromEnd(head, 2);
        printList(listNode);
    }
}
