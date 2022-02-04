package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;
public class ReverseNodesInKGroups {
    /*
 Runtime: 0 ms
 Memory Usage: 39.3 MB
*/
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        int iteration = length(head) / k;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        ListNode b = head; // initially b is the original head
        while (iteration != 0){
            ListNode[] r = reverse(k, b);
            p.next = r[0]; // connect tail to the newly reversed head.
            b = r[1]; // b is now the head node of the rest of the list that still needs to be reversed
            while (p.next != null) p = p.next; // you moved p till the tail of the reversed list
            iteration--;
        }
        p.next = b;
        return result.next;
    }
    public ListNode[] reverse(int k, ListNode head){
        ListNode a = null, b = head;
        ListNode[] r = new ListNode[2];
        while (b != null && k != 0){
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
            k--;
        }
        r[0] = a; r[1] = b; // a is now the head of the reversed list and b is the node after
        return r;
    }
    public int length(ListNode l){
        int len = 0;
        while (l != null){
            len++;
            l = l.next;
        }
        return len;
    }
    /* Crazy Code*/
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode pointerToKthNode = head;
        ListNode ktail = null;
        ListNode result_head = null; // final result
        while (pointerToKthNode != null) { // Keep going until there are nodes in the list
            int count = 0;
            pointerToKthNode = head; // Start counting nodes from the head
            while (count < k && pointerToKthNode != null) { // Find the head of the next k nodes
                pointerToKthNode = pointerToKthNode.next;
                count += 1;
            }
            if (count == k) { // If we counted k nodes, reverse them
                ListNode revHead = this.reverseLinkedList(head, k); // Reverse k nodes and get the new head
                if (result_head == null) // result_head is the head of the final linked list, happens only first time.
                    result_head = revHead;
                if (ktail != null) // ktail is the tail of the previous block of reversed k nodes
                    ktail.next = revHead;
                ktail = head;
                head = pointerToKthNode;
            }
        }
        if (ktail != null) // attach the final, possibly un-reversed portion
            ktail.next = head;
        return result_head == null ? head : result_head;
    }
    /* Reverse k nodes of the given linked list.
       This function assumes that the list contains
     atleast k nodes. */
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;
        while (k > 0) {
            ListNode next_node = ptr.next; // Keep track of the next node to process in the original list
            ptr.next = new_head; // Insert the node pointed to by "ptr" at the beginning of the reversed list
            new_head = ptr;
            ptr = next_node; // Move on to the next node
            k--; // Decrement the count of nodes to be reversed by 1
        }
        return new_head; // Return the head of the reversed list
    }
    public static void main(String[] args){
        ReverseNodesInKGroups rk = new ReverseNodesInKGroups();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode result = rk.reverseKGroup(head, 3);
        while (result != null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
