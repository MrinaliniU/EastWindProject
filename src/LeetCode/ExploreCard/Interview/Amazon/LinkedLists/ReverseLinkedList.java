package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;
/*
    Runtime: 0 ms
    Memory Usage: 39.2 MB
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode a = null, b = head;
        while (b != null){
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
    public static void main(String[] args){
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode r = rll.reverseList(head);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
    }
}
