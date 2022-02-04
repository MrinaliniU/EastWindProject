package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;

public class MergeTwoSortedLists {
    /*
        In place merge
        Runtime: 0 ms
        Memory Usage: 39.1 MB
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pointer.next = l1;
                l1 = l1.next;
            }else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = l1 == null ? l2 : l1;
        return result.next;
    }
    /*
    Runtime: 0 ms
    Memory Usage: 39 MB
 */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode r_pointer = result;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                r_pointer.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                r_pointer.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            r_pointer = r_pointer.next;
        }
        while (l2 != null){
            r_pointer.next = new ListNode(l2.val);
            l2 = l2.next;
            r_pointer = r_pointer.next;
        }
        while (l1 != null){
            r_pointer.next = new ListNode(l1.val);
            l1 = l1.next;
            r_pointer = r_pointer.next;
        }
        return result.next;
    }

    public static void main(String[] args){
        MergeTwoSortedLists ml = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = ml.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
