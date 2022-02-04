package LeetCode.Algorithms.Easy;
/*
    Problem No. 206.
 */
import Notes.LinkedList.SinglyLinkedList.LinkedList;
import Notes.DataStructures.ListNode;

public class ReverseLinkedList {

    /* Recursion
    public ListNode reverseListRecursion(ListNode head){

    } */

    /* Iterative way */
    public ListNode<Integer> reverseList(ListNode<Integer> head){
        if(head == null || head.next == null)
            return head;
        ListNode<Integer> previous = null;
        ListNode<Integer> next = head.next;
        while (next != null){
            head.next = previous;
            previous = head;
            head = next;
            next = head.next;
            if(next == null){
                head.next = previous;
                previous = head;
            }
        }
        return previous;
    }
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        ReverseLinkedList rll = new ReverseLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        ListNode<Integer> head = list.head;
        head = rll.reverseList(head);
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
