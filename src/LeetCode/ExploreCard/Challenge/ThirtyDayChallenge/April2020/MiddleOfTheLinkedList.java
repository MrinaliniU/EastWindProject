package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import Notes.DataStructures.ListNode;

public class MiddleOfTheLinkedList {
    /*
        Runtime: 0 ms
        Memory Usage: 36.5 MB
     */
    public ListNode<Integer> middleNode(ListNode<Integer> head) {
        ListNode<Integer> slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
    public static void main(String[] args){
        MiddleOfTheLinkedList mf = new MiddleOfTheLinkedList();
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
        System.out.println(mf.middleNode(head).value);
    }
}
