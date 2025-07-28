package linkedList;

import org.junit.Test;

public class Leecode234 extends LinkedListUtils{
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        while (head2 != null){
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        reverseList(head2);
        return true;
    }

    /**
     * 链表的中间结点 876
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 反转链表 206
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    @Test
    public  void test(){
        int[] values = {1,2,2,1};
        ListNode head = newLinkedList(values);
        System.out.println(isPalindrome(head));
    }

}
