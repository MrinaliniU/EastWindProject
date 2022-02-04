package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

public class Partition_4 {
    public ListNode<Integer> partition(ListNode<Integer> head, int partition){
        if(head == null) return null;
        ListNode<Integer> tail = head.next;
        ListNode<Integer> resultHead = new ListNode<Integer>(head.value);
        ListNode<Integer> resultTail = resultHead;
        while (tail != null){
            ListNode<Integer> l = new ListNode<Integer>(tail.value);
            if(tail.value >= partition){
                resultTail.next = l;
                resultTail = l;
            }else{
                l.next = resultHead;
                resultHead = l;
            }
            tail = tail.next;
        }
        return resultHead;
    }
    /* This makes arrangement of the elements less stable. That is the order of the nodes gets completely messed
     * up other than the necessary partition around the partition element.
     * If you need to maintain some stability in the resulting list. You can create two list called before list and
     * after list. We can iterate over the original list and fill up these two before and after list. Once that is done
     * the before and after list can be merged at tail end of before to head end of after. */
    public static void main(String[] args){
        Partition_4 p4 = new Partition_4();
        ListNode<Integer> l1 = new ListNode<Integer>(3);
        l1.next = new ListNode<Integer>(5);
        l1.next.next = new ListNode<Integer>(8);
        l1.next.next.next = new ListNode<Integer>(5);
        l1.next.next.next.next = new ListNode<Integer>(10);
        l1.next.next.next.next.next = new ListNode<Integer>(2);
        l1.next.next.next.next.next.next = new ListNode<Integer>(1);
        ListNode<Integer> newList = p4.partition(l1, 5);
        while (newList != null){
            System.out.print(newList.value + " -> ");
            newList = newList.next;
        }
    }
}
