package LeetCode.ExploreCard.Learn.LinkedList;
/* Runtime: 16 ms, faster than 10.23%
*  Memory Usage: 48.3 MB, less than 5.55% */
class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}
class MyLinkedList {
    private int size;
    ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        ListNode current = this.head;
        while(index > 0){
            current = current.next;
            index--;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) return;
        ListNode newnode = new ListNode(val);
        if(index == 0){
            newnode.next = this.head;
            this.head = newnode;
        }else{
            ListNode prev = this.head;
            while(index > 1){
                prev = prev.next;
                index--;
            }
            newnode.next = prev.next;
            prev.next = newnode;
        }
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size) return;
        if(index == 0){
            this.head = head.next;
        }else{
            ListNode prev = this.head;
            while(index > 1){
                prev = prev.next;
                index--;
            }
            prev.next = prev.next.next;
        }
        this.size--;
    }
}

public class SinglyLinkedList{
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);

        ListNode l = list.head;
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}