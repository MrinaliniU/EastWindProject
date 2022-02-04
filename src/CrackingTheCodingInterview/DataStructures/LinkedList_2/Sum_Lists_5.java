package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

/*
    Two numbers are represented via a linked list each digit for a node. Return the sum of these two numbers
    as another linked list in the same format that is one node for each node.
    1 -> 9 -> 3 -> null + 1 -> 2 -> null = 2 -> 0 -> 5 -> null (193 + 12 = 205).
    Solve the same problem when the number is represented in reverse. return the result in reverse as well.
    5 -> 3 -> 2 -> null + 4 -> 9 -> 1 -> null = 9 -> 2 -> 4 -> null (235 + 194 = 429).
 */
public class Sum_Lists_5 {

    public ListNode<Integer> reverseListSum(ListNode<Integer> h1, ListNode<Integer> h2){
        ListNode<Integer> l1 = h1, l2 = h2;
        ListNode<Integer> result = new ListNode<>(0);
        ListNode<Integer> r = result;
        int mod, sum;
        int carry = 0;
        while (l1 != null || l2 != null){
            sum = l1 == null ? l2.value + carry : l2 == null? l1.value + carry : l1.value + l2.value + carry;
            mod = sum % 10;
            carry = sum / 10;
            r.next = new ListNode<>(mod);
            if(l2 != null) l2 = l2.next;
            if(l1 != null) l1 = l1.next;
            r = r.next;
        }
        if(carry > 0) r.next = new ListNode<Integer>(carry);
        return result.next;
    }

    /* This becomes more challenging one because the addition is done from 1's place to n's place and carry moves
    * backwards two because the two lists might not be of same length and aligning 1's, 10's place etc becomes
    * tricky.
    * We can solve the first challenge by using recursion. Note that reverseListSum can also be implemented
    * recursively but it is more relevant here.
    * The second challenge can be solved by padding the shorter list with 0s.
    * The recursive function needs both carry and the ListNode with mod value returned so we create a class
    * called PartialSum that creates the result sum linked list */
    static class PartialSum{
        ListNode<Integer> partialSumNode;
        int carry;
       PartialSum(ListNode<Integer> partialSumNode, int carry){
            this.carry = carry;
            this.partialSumNode = partialSumNode;
        }
    }
    public ListNode<Integer> listSum(ListNode<Integer> h1, ListNode<Integer> h2){
        int len1 = listLen(h1);
        int len2 = listLen(h2);
        if(len1 > len2)
            h2 = padListWithZeros(h2, len1 - len2);
        else if (len2 > len1)
            h1 = padListWithZeros(h1, len2 - len1);

        PartialSum result = recurse(h1, h2);
        if(result.carry > 0){
            ListNode<Integer> firstDigit = new ListNode<>(result.carry);
            firstDigit.next = result.partialSumNode;
            result.partialSumNode = firstDigit;
        }
        return result.partialSumNode;
    }
    public PartialSum recurse(ListNode<Integer> l1, ListNode<Integer> l2){
        if(l1 == null && l2 == null) return new PartialSum(null, 0);
        PartialSum s = recurse(l1.next, l2.next);
        int sum = l1.value + l2.value + s.carry;
        int mod = sum % 10;
        int carry = sum / 10;
        PartialSum p = new  PartialSum(new ListNode<Integer>(mod), carry);
        p.partialSumNode.next = s.partialSumNode;
        return p;
    }
    public int listLen(ListNode<Integer> head){
        ListNode<Integer> l = head;
        int len = 0;
        while (l != null){
            len++;
            l = l.next;
        }
        return len;
    }
    public ListNode<Integer> padListWithZeros(ListNode<Integer> head, int numberOfZeros){
        while (numberOfZeros != 0){
            ListNode<Integer> temp = new ListNode<Integer>(0);
            temp.next = head;
            head = temp;
            numberOfZeros--;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode<Integer> l1 = new ListNode<Integer>(9);
        l1.next = new ListNode<Integer>(9);
        ListNode<Integer> l2 = new ListNode<Integer>(1);
        Sum_Lists_5 sl5 = new Sum_Lists_5();
        ListNode<Integer> l1_t = l1;
        ListNode<Integer> l2_t = l2;
        ListNode<Integer> result = sl5.listSum(l1_t, l2_t);
        while(result != null){
            System.out.print(result.value + " -> ");
            result = result.next;
        }
        System.out.println();
        l1_t = l1;
        l2_t = l2;
        ListNode<Integer> result2 = sl5.reverseListSum(l1_t, l2_t);
        while(result2 != null){
            System.out.print(result2.value + " -> ");
            result2 = result2.next;
        }
    }
}
