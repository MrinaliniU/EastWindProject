package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

import java.util.HashSet;

public class RemoveDups_1 {

    /* O(n) runtime and O(n) space */
    public ListNode<Integer> removeDuplicatesHash(ListNode<Integer> head){
        HashSet<Integer> set = new HashSet<>();
        ListNode<Integer> pointer = head;
        ListNode<Integer> previous = null;
        while(pointer != null){
            if(!set.contains(pointer.value)) {
                set.add(pointer.value);
                previous = pointer;
            }
            else previous.next = pointer.next;
            pointer = pointer.next;
        }
        return head;
    }
    /* This takes O(n2) runtime and O(N) space. */
    public ListNode<Integer> removeDuplicates(ListNode<Integer> head){
        if(head == null) return null;
        ListNode<Integer> a = head;
        ListNode<Integer> x = a;
        ListNode<Integer> y = x.next;
        while (a != null){
            while(y != null){
                if(y.value.equals(a.value)) x.next = y.next;
                else x = x.next;
                y = y.next;
            }
            a = a.next;
            x = a;
            if(x != null) y = x.next;
        }
        return head;
    }
    public static void main(String[] args){
        RemoveDups_1 d1 = new RemoveDups_1();
        ListNode<Integer> l1 = new ListNode<Integer>(1);
        l1.next = new ListNode<Integer>(2);
        l1.next.next = new ListNode<Integer>(1);
        l1.next.next.next = new ListNode<Integer>(2);
        l1.next.next.next.next = new ListNode<Integer>(3);
        l1.next.next.next.next.next = new ListNode<Integer>(4);
        l1.next.next.next.next.next.next = new ListNode<Integer>(3);
        l1.next.next.next.next.next.next.next = new ListNode<Integer>(5);
        l1.next.next.next.next.next.next.next.next = new ListNode<Integer>(5);
        ListNode<Integer> resultHead = d1.removeDuplicates(l1);
        while(resultHead != null){
            System.out.print(resultHead.value + " -> ");
            resultHead = resultHead.next;
        }
        System.out.println();
        ListNode<Integer> l2 = new ListNode<Integer>(1);
        l2.next = new ListNode<Integer>(2);
        l2.next.next = new ListNode<Integer>(1);
        l2.next.next.next = new ListNode<Integer>(2);
        l2.next.next.next.next = new ListNode<Integer>(3);
        l2.next.next.next.next.next = new ListNode<Integer>(4);
        l2.next.next.next.next.next.next = new ListNode<Integer>(3);
        l2.next.next.next.next.next.next.next = new ListNode<Integer>(5);
        l2.next.next.next.next.next.next.next.next = new ListNode<Integer>(5);
        ListNode<Integer> resultHead2 = d1.removeDuplicatesHash(l1);
        while(resultHead2 != null){
            System.out.print(resultHead2.value + " -> ");
            resultHead2 = resultHead2.next;
        }

    }
}
