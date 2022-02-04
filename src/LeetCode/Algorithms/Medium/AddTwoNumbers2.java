package LeetCode.Algorithms.Medium;

import Notes.DataStructures.ListNode;

public class AddTwoNumbers2 {

    /*
        Runtime: 2 ms, faster than 99.05%
        Memory Usage: 40.9 MB, less than 79.41%
     */
    public ListNode<Integer> addTwoNumbers(ListNode<Integer> head1, ListNode<Integer> head2){
        int len1 = findLengthOfThe(head1);
        int len2 = findLengthOfThe(head2);
        int diff = Math.abs(len1 - len2);
        if(len1 > len2) head2 = appendZeros(head2, diff);
        else if(len2 > len1) head1 = appendZeros(head1, diff);
        TempSum temp = recursion(head1, head2);
        if (temp.carry > 0) {
            ListNode<Integer> result = new ListNode<>(temp.carry);
            result.next = temp.temp;
            return result;
        }
        return temp.temp;
    }

    static class TempSum{
        int carry = 0;
        ListNode<Integer> temp = null;
    }
    public TempSum recursion(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1 == null && head2 == null) return new TempSum();
        TempSum temp = recursion(head1.next, head2.next);
        int sum = head1.value + head2.value + temp.carry;
        int mod = sum % 10;
        int carry = sum / 10;
        TempSum myTemp = new TempSum();
        myTemp.carry = carry;
        myTemp.temp = new ListNode<>(mod);
        myTemp.temp.next = temp.temp;
        return myTemp;
    }
    public ListNode<Integer> appendZeros(ListNode<Integer> head, int numberOfZeros){
        while (numberOfZeros != 0){
            ListNode<Integer> temp = new ListNode<>(0);
            temp.next = head;
            head = temp;
            numberOfZeros--;
        }
        return head;
    }
    public int findLengthOfThe(ListNode<Integer> head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public static void main(String[] args){
        ListNode<Integer> head1 = new ListNode<>(7);
        head1.next = new ListNode<>(2);
        head1.next.next = new ListNode<>(4);
        head1.next.next.next = new ListNode<>(3);
        ListNode<Integer> head2 = new ListNode<>(5);
        head2.next = new ListNode<>(6);
        head2.next.next = new ListNode<>(4);
        AddTwoNumbers2 a2 = new AddTwoNumbers2();
        ListNode<Integer> result = a2.addTwoNumbers(head1, head2);
        while(result != null){
            System.out.print(result.value + " -> ");
            result = result.next;
        }
    }
}
