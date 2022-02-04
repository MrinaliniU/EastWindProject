package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

import java.util.Stack;
/*
    1. Reverse and clone the linked list. This can be done in o(N) time. First cloned node you create is marked head
    and points to null and every next node you create is attached to the back of the head and head pointer is moved to
    this node.
    head -> null then create newNode. Point newNode.next to head. Move head pointer to newNode.
    Now all you need to do is compare the value of original list and reverse list to have same data.
    2. Stack can be used to store first half of the list. This is done by using Fast/Slow Pointer. This method is
    implemented below.
    3. Recursive method can also be used as shown below.
 */
public class Palindrome_6 {

    public boolean isPalindrome(ListNode<Integer> head){
        if(head.next == null) return true; // when only one element return true;
        ListNode<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        /* Move first half of the list to a stack */
        ListNode<Integer> stackPointer = head;
        Stack<Integer> halfStack = new Stack<>();
        while (stackPointer != slow){
            halfStack.add(stackPointer.value);
            stackPointer = stackPointer.next;
        }
        /* if fast == null it means it is the linked list was even length.
        If not it means the length is odd and slow pointer is pointing to the middle element.
        in a palindrome of odd length middle element can be anything so we move pointer to next element.
        IT IS IMPORTANT THAT BELOW LINE OF CODE IS AFTER THE STACK IS CREATED. This is because we use slow
        pointer as a stopping point for half stack creation. If we move stack pointer before stack creation the
        middle element of an odd length linked list will also be added to the stack. */
        if(fast != null) slow = slow.next;
        while (slow != null){
            if (!halfStack.pop().equals(slow.value)) return false;
            slow = slow.next;
        }
        return halfStack.isEmpty();
    }

    /*
        Logic for the recursive method is complicated and is better explained in cracking the coding interview
        book page 218.
     */
    static class Result{
        ListNode<Integer> node;
        boolean isPalindrome;
        Result(ListNode<Integer> node, boolean isPalindrome){
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }
    public boolean isPalindromeRecursion(ListNode<Integer> head){
        int len = lenOfList(head);
        return recurse(head, len).isPalindrome;
    }
    public int lenOfList(ListNode<Integer> head){
        ListNode<Integer> l1 = head;
        int len = 0;
        while(l1 != null){
            len++;
            l1 = l1.next;
        }
        return len;
    }
    public Result recurse(ListNode<Integer> head, int len){
        if(len == 1) return new Result(head.next, true);
        if(len == 0) return new Result(head, true);
        Result returnedResult = recurse(head.next, len - 2);
        if(returnedResult.isPalindrome && returnedResult.node.value.equals(head.value))
            return new Result(returnedResult.node.next, true);
        return new Result(returnedResult.node.next, false);
    }
    public static void main(String[] args){
        Palindrome_6 p6 = new Palindrome_6();
        ListNode<Integer> l1 = new ListNode<Integer>(1);
        l1.next = new ListNode<Integer>(2);
        l1.next.next = new ListNode<Integer>(2);
        l1.next.next.next = new ListNode<Integer>(1);
        //l1.next.next.next.next = new ListNode(1);
        System.out.println("The list is a palindrome " + p6.isPalindromeRecursion(l1));
    }
}
