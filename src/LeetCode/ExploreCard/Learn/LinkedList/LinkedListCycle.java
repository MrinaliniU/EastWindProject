package LeetCode.ExploreCard.Learn.LinkedList;
/*
    problem No. 141.
    1. If there is no cycle, the fast pointer takes
    N/2 times to reach the end of the linked list,
    where N is the length of the linked list.
    2. If there is a cycle, the fast pointer needs
    M times to catch up the slower pointer,
    where M is the length of the cycle in the list.
 */
import Notes.DataStructures.ListNode;

public class LinkedListCycle {

    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 40.8 MB, less than 5.71%
     */
    public boolean hasCycle(ListNode<Integer> head){
        if(head == null || head.next == null) return false;
        ListNode<Integer> slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer.equals(fastPointer)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        LinkedListCycle ls = new LinkedListCycle();
        ListNode<Integer> head = new ListNode<Integer>(3);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(0);
        head.next.next.next = new ListNode<Integer>(-4);
        head.next.next.next.next = head.next.next.next;
        System.out.println("the list has cycle " + ls.hasCycle(head));
    }
}
