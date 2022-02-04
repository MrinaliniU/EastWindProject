package LeetCode.ExploreCard.Learn.LinkedList;

public class RemoveNthNodeFromEndList {
    /* Could you do this in one pass?  n is always valid
    *   Runtime: 0 ms
        Memory Usage: 37.9 MB  */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode slow = head, fast = head, slowPrev = null;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast != null){
            fast = fast.next;
            slowPrev = slow;
            slow = slow.next;
        }
        if(slowPrev == null) head = head.next;
        else slowPrev.next = slow.next;
        return head;
    }
    public static void main(String[] args){
        RemoveNthNodeFromEndList rn = new RemoveNthNodeFromEndList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = rn.removeNthFromEnd(head, 5);
        while (newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
