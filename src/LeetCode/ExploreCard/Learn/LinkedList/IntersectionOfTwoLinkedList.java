package LeetCode.ExploreCard.Learn.LinkedList;

import Notes.DataStructures.ListNode;

/*
    #with outer if loop
    Runtime: 1 ms, faster than 97.58%
    Memory Usage: 42.3 MB, less than 5.71%

    #with outer while loop
    Runtime: 3 ms
    Memory Usage: 53.7 MB
            while(len > 0){
            if(lenA > lenB) headA = headA.next;
            else headB = headB.next;
            len--;
        }
 */

public class IntersectionOfTwoLinkedList {
    public ListNode<Integer> getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int len = Math.abs(lenA - lenB);
        if (lenA > lenB) { // faster Runtime: 1 ms, faster than 98.26%
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null && headB != null && !headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int getLen(ListNode<Integer> list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        return len;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList is = new IntersectionOfTwoLinkedList();
        ListNode<Integer> headA = new ListNode<>(4);
        headA.next = new ListNode<>(1);
        headA.next.next = new ListNode<>(8);
        headA.next.next.next = new ListNode<>(4);
        headA.next.next.next.next = new ListNode<>(5);
        headA.next.next.next.next.next = null;
        /* ----------------- */
        ListNode<Integer> headB = new ListNode<>(5);
        headB.next = new ListNode<>(0);
        headB.next.next = new ListNode<>(1);
        headB.next.next.next = headA.next.next;
        System.out.println("The intersection node is " + is.getIntersectionNode(headA, headB).value);
        /* TEST CASE 2 */
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next = new ListNode<>(2);
        head1.next.next = new ListNode<>(3);
        /* ----- */
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next = new ListNode<>(3);
        head2.next.next = new ListNode<>(4);
        System.out.println("The intersection node is " + is.getIntersectionNode(head1, head2));
    }
}
