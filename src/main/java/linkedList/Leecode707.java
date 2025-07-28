package linkedList;

import org.junit.Test;

public class Leecode707 {
    /**
     * 单链表实现
     */
//class MyLinkedList{
//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//    // 链表元素的个数
//    private int size;
//    // 哨兵结点
//    private ListNode head;
//    // 初始化链表
//    public MyLinkedList() {
//        this.size = 0;
//        this.head = new ListNode(0);
//    }
//    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//    public int get(int index) {
//        if (index<0 || index>size-1) return -1;
//        ListNode cur = head.next;
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
//        return cur.val;
//    }
//    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//    public void addAtHead(int val) {
//        ListNode node = new ListNode(val);
//        node.next = head.next;
//        head.next = node;
//        size++;
//    }
//    // 将值为 val 的节点追加到链表的最后一个元素。
//    public void addAtTail(int val) {
//        ListNode node = new ListNode(val);
//        ListNode cur = head;
//        while (cur.next != null){
//            cur = cur.next;
//        }
//        cur.next = node;
//        node.next = null;
//        size++;
//    }
//    // 在链表中的第 index 个节点之前添加值为 val  的节点。
//    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
//    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//    public void addAtIndex(int index, int val) {
//        if (index > size) return;
//        if (index == size) {
//            addAtTail(val);
//            return;
//        }
//        if (index < 0) {
//            addAtHead(val);
//            return;
//        }
//        ListNode node = new ListNode(val);
//        ListNode cur = head;  // 要找到index位置之前的结点
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
//        node.next = cur.next;
//        cur.next = node;
//        size++;
//    }
//    //如果索引 index 有效，则删除链表中的第 index 个节点。
//    public void deleteAtIndex(int index) {
//        if (index<0 || index>size-1) return;
//        ListNode cur = head;
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        size--;
//    }
//}

    /**
     * 双链表实现
     */
    class MyLinkedList {
        class ListNode{
            int val;
            ListNode next,prev;
            ListNode(){}
            ListNode(int val){
                this.val = val;
            }
        }
        private int size;
        // 记录链表的虚拟头结点和尾结点
        private ListNode head,tail;

        // 初始化链表
        public MyLinkedList(){
            this.size = 0;
            this.head = new ListNode();
            this.tail = new ListNode();
            // 关键步骤,将初始化链表中的头尾结点连接起来
            this.head.next = tail;
            this.tail.prev = head;
        }
        // 获取第index个节点的数值
        public int get(int index){
            if (index<0 || index>=size) return -1;
            ListNode cur = head.next; // 要找的是当前结点
            // 判断从哪一边遍历，时间更短
            if (index >= size/2){ // 从尾结点遍历更快
                cur = tail.prev; // 要找的是当前结点
                for (int i = 0; i < size-1-index; i++) {
                    cur = cur.prev;
                }
            }
            else {  // 从头结点遍历
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            }
            return cur.val;
        }

        // 首端插入
        public void addAtHead(int val){
            ListNode newNode = new ListNode(val);
            // 注意必须双向连接
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            size++;
        }
        // 尾端插入
        public void addAtTail(int val){
            ListNode newNode = new ListNode(val);
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        }
        //在链表中的第 index 个节点之前添加值为 val  的节点。
        //如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        //如果 index 大于链表长度，则不会插入节点。
        //如果index小于0，则在头部插入节点。
        public void addAtIndex(int index, int val){
            if (index > size) return;
            if (index < 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            // 找到要插入位置的前驱结点
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next.prev = newNode;
            cur.next = newNode;
            newNode.prev = cur;
            size++;
        }
        // 删除索引结点
        public void deleteAtIndex(int index){
            //判断index是否有效
            if(index < 0 || index >= size) return;
            //删除操作
            ListNode cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            // 更新两个指针
            cur.next = cur.next.next;
            cur.next.prev = cur;
            size--;
        }
    }

    @Test
    public void test(){
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtTail(2);
//        linkedList.addAtIndex(1,8);
//        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(0);
        printList(linkedList.head.next);
    }
    /**
     * 打印链表
     * @param head
     */
    private void printList(MyLinkedList.ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
