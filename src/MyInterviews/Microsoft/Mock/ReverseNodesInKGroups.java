package MyInterviews.Microsoft.Mock;

import Notes.DataStructures.ListNode;

/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesInKGroups {
        /*
        Runtime: 1 ms, faster than 28.76%
        Memory Usage: 41.1 MB, less than 5.17%
        My Code
        */
    public ListNode<Integer> reverseKGroup(ListNode<Integer> head, int k){
        if(head == null) return null;
        if(k <= 0) return head;
        ListNode<Integer> newHead = new ListNode<>(0);
        ListNode<Integer> backPointer = newHead;
        int len = findLength(head);
        len = len / k;
        while (head != null && len != 0){
            int temp = k;
            while (head != null && temp != 0){
                ListNode<Integer> listNode = new ListNode<>(head.value);
                ListNode<Integer> backPointerNext = backPointer.next;
                backPointer.next = listNode;
                listNode.next = backPointerNext;
                head = head.next;
                temp--;
            }
            temp = k;
            while (temp != 0){
                backPointer = backPointer.next;
                temp--;
            }
            temp = k;
            len--;
        }
        while (head != null && backPointer != null){
            backPointer.next = new ListNode<>(head.value);
            head = head.next;
            backPointer = backPointer.next;
        }
        return newHead.next;
    }
    public int findLength(ListNode<Integer> head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
        head.next.next.next.next.next.next = new ListNode<>(7);
        head.next.next.next.next.next.next.next = new ListNode<>(8);
        ReverseNodesInKGroups rk = new ReverseNodesInKGroups();
        ListNode<Integer> result = rk.reverseKGroup(head, 0);
        while(result != null){
            System.out.print(result.value + " -> ");
            result = result.next;
        }
    }
}
