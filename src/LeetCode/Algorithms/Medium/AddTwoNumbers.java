package LeetCode.Algorithms.Medium;

import Notes.DataStructures.ListNode;

public class AddTwoNumbers {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> x = l1; ListNode<Integer> y = l2;
        ListNode<Integer> temp = new ListNode<>(9);
        ListNode<Integer> curr = temp;
        int carry = 0;
        int sum = 0;
        while(x != null | y != null){
            int p = (x == null)? 0 : x.value;
            int q = (y == null)? 0: y.value;
            sum = carry + p + q;
            carry = sum / 10;
            curr.next = new ListNode<Integer>(sum % 10);
            curr = curr.next;
            if(x != null) x = x.next;
            if(y != null) y = y.next;

        }
        if(carry > 0){
            curr.next = new ListNode<Integer>(carry);
        }

        return temp.next;
    }

    public static void main(String[] args){
        ListNode<Integer> l1 = new ListNode<Integer>(9);
        l1.next = new ListNode<Integer>(9);
        ListNode<Integer> l2 = new ListNode<Integer>(1);
        AddTwoNumbers at = new AddTwoNumbers();
        ListNode<Integer> t = at.addTwoNumbers(l1, l2);
        while(t != null){
            System.out.print(t.value + " -> ");
            t = t.next;
        }
    }
}
