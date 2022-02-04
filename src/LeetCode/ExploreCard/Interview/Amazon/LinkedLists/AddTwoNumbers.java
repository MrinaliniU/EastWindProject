package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;
public class AddTwoNumbers {
    /*
            Runtime: 2 ms
            Memory Usage: 39.7 MB
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0, mod = 0;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while(l1 != null || l2 != null){
            sum = carry + (l1 == null ? l2.val : l2 == null ? l1.val : l1.val + l2.val);
            mod = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(mod);
            p = p.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) p.next = new ListNode(carry);
        return result.next;
    }
    public static void main(String[] args){
        AddTwoNumbers s2 = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l = s2.addTwoNumbers(l1, l2);
        while(l != null){
            System.out.print(l.val + " -> ");
            l = l.next;
        }
    }
}
