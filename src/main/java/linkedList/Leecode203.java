package linkedList;

import org.junit.Test;

public class Leecode203 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    /**
     * 不加哨兵结点移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        // 删除头结点,删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val){
            head = head.next;
        }
        // 删除其他结点
        ListNode cur = head;
        // cur!=null防止删除头结点后，直接变成空链表
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else cur = cur.next;

        }
        return head;
    }

    /**
     * 有哨兵结点移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        // 增加一个哨兵结点
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        // 确保当前结点后还有结点
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return dummyNode.next;
    }
    /**
     * 使用递归思想移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        //递归终止条件
        if (head == null){
            return null;
        }
        // 递归处理子问题
        head.next = removeElements3(head.next,val);
        if (head.val == val){
            return head.next;
        }
        else return head;
    }

    @Test
    public void test1(){
        int[] values = {1,2,6,3,4,5,6};
        ListNode n = new ListNode(0);
        ListNode cur = n;
        for (int value : values) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
//        printList(removeElements1(n.next,6));
//        printList(removeElements2(n.next,6));
        printList(removeElements3(n.next,6));

    }
//--------------------------------------------------------------------------------------

    /**
     * 打印链表
     * @param head
     */
    private void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
