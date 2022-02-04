package ElementsOfProgrammingInterview.LinkedList;

import Notes.DataStructures.ListNode;

public class TestForCyclicity_3 {

    public ListNode<Integer> testForCycle(ListNode<Integer> node) {
        ListNode<Integer> s = node;
        ListNode<Integer> f = node;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) break;
        }
        if (f == null || f.next == null) return null;
        s = node;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1);
        node.next = new ListNode<>(2);
        node.next.next = new ListNode<>(3);
        node.next.next.next = new ListNode<>(4);
        node.next.next.next.next = new ListNode<>(5);
        node.next.next.next.next.next = new ListNode<>(6);
        node.next.next.next.next.next.next = new ListNode<>(7);
        node.next.next.next.next.next.next.next = new ListNode<>(8);
        node.next.next.next.next.next.next.next.next = new ListNode<>(9);
        node.next.next.next.next.next.next.next.next.next = new ListNode<>(10);
        node.next.next.next.next.next.next.next.next.next.next = node.next.next;

        TestForCyclicity_3 tc = new TestForCyclicity_3();
        ListNode<Integer> result = tc.testForCycle(node);
        if (result == null) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle found at " + result.value);
        }

    }
}
