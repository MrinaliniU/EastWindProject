package LeetCode.Algorithms.Easy;

import Notes.DataStructures.ListNode;
/*
    Problem No. 234.
 */
public class LinkedListPalindrome {

    /*
        Runtime: 1 ms, faster than 96.81%
        Memory Usage: 42.2 MB, less than 30.49%
     */
    public boolean isPalindrome(ListNode<Integer> head){
        if(head == null) return true; // Crazy. I know!
        /* Find Length of the List*/
        int listLength = 0;
        boolean isOddLength = true;
        ListNode<Integer> lenPointer = head;
        while(lenPointer != null){
            listLength++;
            lenPointer = lenPointer.next;
        }
        /* Move to middle of the list */
        int moveHead = (listLength / 2);
        if(listLength % 2 == 0) {
            moveHead -= 1;
            isOddLength = false;
        }
        ListNode<Integer> midPointer = head;
        while (moveHead != 0){
            midPointer = midPointer.next;
            moveHead--;
        }
        /* Reverse the second half of the list */
        ListNode<Integer> prev = midPointer;
        ListNode<Integer> curr = midPointer.next;
        while(curr != null){
            ListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        /* Prev now points to the last node. Navigate prev till midPointer. Check if elements from head
        * midPointer is same as from prev to midPointer */
        ListNode<Integer> palCheckPointer = head;
        if(isOddLength){
            while (!palCheckPointer.equals(midPointer) && !prev.equals(midPointer)){
                if(palCheckPointer.value != prev.value) return false;
                palCheckPointer = palCheckPointer.next;
                prev = prev.next;
            }
        }else{
            while (!palCheckPointer.equals(midPointer.next) && !prev.equals(midPointer)){
                if(palCheckPointer.value != prev.value) return false;
                palCheckPointer = palCheckPointer.next;
                prev = prev.next;
            }
        }

        return true;
    }

    public static void main(String[] args){
        LinkedListPalindrome lp = new LinkedListPalindrome();
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(1);
        head.next.next = new ListNode<Integer>(2);
        head.next.next.next = new ListNode<Integer>(2);
        head.next.next.next.next = new ListNode<Integer>(1);
        System.out.println("The given list is a palindrome " + lp.isPalindrome(head));
    }
}
