package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

public class Loop_Detection_8 {

    /*
        - Have two pointer p1 and p2. Every time p1 jumps one step p2 jumps two steps.
        - If there is a loop at one point p1 and p2 will point at the same node.
        - If no loop then p2 will hit null.
     */

    /*
        If p2 starts at first node then p1 and p2 will meet at a point that is k nodes behind the
        start of the cycle node. Where k is the number of nodes before the cycle starts.
        To find this node when p1 and p2 meet initially:
        - move p1 to head and keep p2 at its place.
        - move both p1 and p2 till they meet and they will meet at the start of the cycle node.
        - return this node.
     */
    public ListNode findStartOfCycleA(ListNode head){
        ListNode A = head, B = head;
        while (B != null && B.next != null){
            A = A.next;
            B = B.next.next;
            if(A == B)
                break;
        }
        if(B == null || B.next == null) return null;
        A = head;
        while (A != B){
            A = A.next;
            B = B.next;
        }
        return B;
    }

    /*
        If p2 starts at second node then similar to previous method you need to move p1 back to head, keep
        p2 at its place, move both p1 and p2 one step till p2.next.next equals p1. At this point p1 will be at
        start of cycle.
     */
    public ListNode findStartOfCycleB(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode A = head; ListNode B = head.next.next;
        while(B != null && A != B){
            A = A.next;
            B = B.next.next;
        }
        if(B == null) return null;
        A = head;
        while(B.next.next != A){
            A = A.next;
            B = B.next;
        }
        return A;
    }

    public static void main(String[] args){
        /* Has Cycle */
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = l1.next;
        /* Has Cycle */
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = l2.next;
        /* Has Cycle */
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(5);
        l3.next.next.next.next.next = l3.next;
        /* No Cycle */
        ListNode l4 = new ListNode(1);
        l4.next = null;
        /* No Cycle */
        ListNode l5 = new ListNode(1);
        l5.next = new ListNode(2);
        /* No Cycle */
        ListNode l6 = new ListNode(1);
        l6.next = new ListNode(2);
        l6.next = new ListNode(3);
        Loop_Detection_8 l8 = new Loop_Detection_8();
        ListNode A1 = l8.findStartOfCycleA(l1);
        ListNode A2 = l8.findStartOfCycleA(l2);
        ListNode A3 = l8.findStartOfCycleA(l3);
        ListNode A4 = l8.findStartOfCycleA(l4);
        ListNode A5 = l8.findStartOfCycleA(l5);
        ListNode A6 = l8.findStartOfCycleA(l6);
        ListNode B1 = l8.findStartOfCycleB(l1);
        ListNode B2 = l8.findStartOfCycleB(l2);
        ListNode B3 = l8.findStartOfCycleB(l3);
        ListNode B4 = l8.findStartOfCycleB(l4);
        ListNode B5 = l8.findStartOfCycleB(l5);
        ListNode B6 = l8.findStartOfCycleB(l6);
        System.out.println("The cycle for l1 starts " + A1.value + " and method B at " + B1.value);
        System.out.println("The cycle for l2 starts " + A2.value + " and method B at " + B2.value);
        System.out.println("The cycle for l3 starts " + A3.value + " and method B at " + B3.value);
        System.out.println("The cycle for l4 starts " + A4 + " and method B at " + B4);
        System.out.println("The cycle for l5 starts " + A5 + " and method B at " + B5);
        System.out.println("The cycle for l6 starts " + A6 + " and method B at " + B6);
    }
}
