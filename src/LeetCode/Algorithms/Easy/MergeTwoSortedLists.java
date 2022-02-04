package LeetCode.Algorithms.Easy;

import Notes.DataStructures.ListNode;

/*
    Problem No. 21.
 */
public class MergeTwoSortedLists {

    /*
         Runtime: 0 ms, faster than 100.00%
         Memory Usage: 38.9 MB, less than 19.53%
     */
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2){
        ListNode<Integer> head = new ListNode<Integer>(0);
        ListNode<Integer> tail = head;
        while(l1 != null && l2 != null){
            if(l1.value <= l2.value){
                tail.next = new ListNode<Integer>(l1.value);
                tail = tail.next;
                l1 = l1.next;
            }else {
                tail.next = new ListNode<Integer>(l2.value);
                tail = tail.next;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            tail.next = new ListNode<Integer>(l1.value);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null){
            tail.next = new ListNode<Integer>(l2.value);
            tail = tail.next;
            l2 = l2.next;
        }
        return head.next;
    }
    public static void main(String[] args){
        //ListNode l1 = null;
        ListNode<Integer> l2 = null;
        ListNode<Integer> l1 = new ListNode<Integer>(1);
        l1.next = new ListNode<Integer>(2);
        l1.next.next = new ListNode<Integer>(4);
        /*ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);*/
        ListNode<Integer> p = l1;
        ListNode<Integer> q = l2;
        while(p != null){
            System.out.print(p.value + "->");
            p = p.next;
        }
        System.out.println();
        while(q != null){
            System.out.print(q.value + "->");
            q = q.next;
        }
        System.out.println();
        MergeTwoSortedLists mt = new MergeTwoSortedLists();
        ListNode<Integer> head = mt.mergeTwoLists(l1, l2);
        while(head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
