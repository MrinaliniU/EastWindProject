package LeetCode.ExploreCard.Learn.LinkedList;

import Notes.DataStructures.ListNode;

public class LinkedListCycle2 {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 41 MB, less than 6.32%
     */
    public ListNode<Integer> detectCycle(ListNode<Integer> head){
        if(head == null) return null;
        ListNode<Integer> slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) break;
        }

        if(fastPointer == null || fastPointer.next == null) return null;
        slowPointer = head;
        while (slowPointer != fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }
    public static void main(String[] args){
        ListNode<Integer> node = new ListNode<>(3);
        node.next = new ListNode<>(2);
        node.next.next = new ListNode<>(0);
        node.next.next.next = new ListNode<>(-4);
        node.next.next.next.next = node.next;
        LinkedListCycle2 l2 = new LinkedListCycle2();
        ListNode<Integer> result = l2.detectCycle(node);
        if(result != null)
            System.out.println("The cycle starts at " + result.value);
        else
            System.out.println("There is no Cycle");
    }
}
