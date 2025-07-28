package linkedList;

public class Leecode142_141 extends LinkedListUtils{
    /**
     * 找循环链表的入口 142
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){ // 判断是否有环
                ListNode indexNode1 = slow; // 保存相遇结点
                ListNode indexNode2 = head; // 保存头结点
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (indexNode2 != indexNode1){
                    indexNode1 = indexNode1.next;
                    indexNode2 = indexNode2.next;
                }
                // 相遇点，则为环的入口
                return indexNode1;
            }
        }
        // 没有环
        return null;
    }

    /**
     * 快慢指针判断是否有环 141
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
