package ElementsOfProgrammingInterview.LinkedList;

import Notes.DataStructures.ListNode;

public class ReverseASingleSubList_2 {

    public ListNode<Integer> reverseSublist(ListNode<Integer> list, int s, int f) {
        ListNode<Integer> dummy = new ListNode<>(0);
        dummy.next = list;
        ListNode<Integer> prev = dummy;
        // move prev to an item before the start element
        int k = s;
        while (k-- > 1) {
            prev = prev.next;
        }
        ListNode<Integer> start = prev.next;
        while (s++ < f) {
            ListNode<Integer> moving = start.next;
            start.next = moving.next;
            moving.next = prev.next;
            prev.next = moving;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseASingleSubList_2 rs2 = new ReverseASingleSubList_2();
        ListNode<Integer> l1 = new ListNode<>(1);
        l1.next = new ListNode<>(2);
        l1.next.next = new ListNode<>(3);
        l1.next.next.next = new ListNode<>(4);
        l1.next.next.next.next = new ListNode<>(5);
        l1.next.next.next.next.next = new ListNode<>(6);
        l1.next.next.next.next.next.next = new ListNode<>(7);
        l1.next.next.next.next.next.next.next = new ListNode<>(8);

        ListNode<Integer> result = rs2.reverseSublist(l1, 4, 7);
        while (result != null) {
            System.out.print(result.value + "->");
            result = result.next;
        }
    }
}
