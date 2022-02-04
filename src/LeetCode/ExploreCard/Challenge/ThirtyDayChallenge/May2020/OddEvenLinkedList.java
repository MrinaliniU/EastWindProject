package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import Notes.DataStructures.ListNode;
/*
    Runtime: 1 ms
    Memory Usage: 41.5 MB
 */
public class OddEvenLinkedList {
    public ListNode<Integer> oddEvenList(ListNode<Integer> head) {
        int len = getListLen(head);
        if(len <= 2) return head;
        if(len % 2 == 0) evenList(head);
        else oddList(head);
        return head;
    }
    public void evenList(ListNode<Integer> a){
        ListNode<Integer> b = a.next, firstOdd = b;
        while (b.next != null){
            a.next = b.next;
            b.next = a.next.next;
            a = a.next;
            b = b.next;
        }
        a.next = firstOdd;
    }
    public void oddList(ListNode<Integer> a){
        ListNode<Integer> b = a.next, firstOdd = b;
        while (b != null){
            a.next = b.next;
            b.next = a.next.next;
            a = a.next;
            b = b.next;
        }
        a.next = firstOdd;
    }
    public int getListLen(ListNode<Integer> head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args){
        OddEvenLinkedList oe = new OddEvenLinkedList();
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
        ListNode<Integer> result = oe.oddEvenList(head);
        while (result != null){
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
