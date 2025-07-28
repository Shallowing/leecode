package linkedList;

public class LinkedListUtils {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val= val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    /**
     * 新建链表
     * @param values
     * @return
     */
    ListNode newLinkedList(int[] values){
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int value : values) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }

    /**
     * 打印链表
     * @param head
     */
    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
