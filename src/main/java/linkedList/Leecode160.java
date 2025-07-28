package linkedList;

public class Leecode extends LinkedListUtils{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        // 有交点时，A=B=焦点；无交点时，A=B=NULL
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        // 返回的是交点或者null
        return A;
    }

}
