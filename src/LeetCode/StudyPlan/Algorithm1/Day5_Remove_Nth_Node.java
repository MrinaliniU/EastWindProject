package LeetCode.StudyPlan.Algorithm1;

import Notes.DataStructures.ListNode;

public class Day5_Remove_Nth_Node {

    ListNode<Integer> resultHead;
    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        this.resultHead = head;
        lenRecurrsion(head, n, null);
        return head;
    }


    public int lenRecurrsion(ListNode<Integer> n, int k, ListNode<Integer> prev) {
        if (n == null) return 0;

        int myLen = lenRecurrsion(n.next, k, n) + 1;

        if (myLen == k) {
            if (prev == null) {
                ListNode<Integer> x = n.next;
                n.next = null;
                resultHead = x;
            } else {
                prev.next = n.next;
            }

        }
        return myLen;
    }

    public static void main(String[] args) {
        Day5_Remove_Nth_Node day5_remove_nth_node = new Day5_Remove_Nth_Node();
        ListNode<Integer> head = new ListNode<>(1);
        day5_remove_nth_node.removeNthFromEnd(head, 1);
    }
}
