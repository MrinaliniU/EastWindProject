package LeetCode.Algorithms.Medium;
import Notes.LinkedList.SinglyLinkedList.ListNode_Random;

import java.util.HashMap;

/*
    Problem No. 138.
 */
public class CopyListWithRandomPointer {
    // TODO: 3/4/2020 #MyInterviews.Microsoft #HashTable #LinkedList

    /* HashMap method  O(n) run-time and o(n) space*/
    public ListNode_Random copyRandomList(ListNode_Random head){
        if(head == null) return null;
        HashMap<ListNode_Random, ListNode_Random> map = new HashMap<>();
        /* First Pass. From the given linked list create a clone node for each node. Store them as key-value
        pairs. Note that the clones don't have any next or random pointers assigned yet.
         */
        ListNode_Random mapPointer = head;
        while (mapPointer != null){
            map.put(mapPointer, new ListNode_Random(mapPointer.value));
            mapPointer = mapPointer.next;
        }
        /* Second pass. Pass through the given linked list and using the hash map connect all the next pointer.
         */
        mapPointer = head;
        while( mapPointer != null){
            ListNode_Random next = mapPointer.next;
            if(next != null)
                map.get(mapPointer).next = map.get(next);
            else
                map.get(mapPointer).next = null;
            mapPointer = mapPointer.next;
        }
        /* Third pass. Pass through the given linked list and using the hash map map all the random pointers.

         */
        mapPointer = head;
        while (mapPointer != null){
            ListNode_Random random = mapPointer.random;
            if(random != null)
                map.get(mapPointer).random = map.get(random);
            else
                map.get(mapPointer).random = null;
            mapPointer = mapPointer.next;
        }
        return map.get(head);
    }

    /* HashMap method  O(n) run-time and O(1) space
    * Runtime: 0 ms, faster than 100.00%
    * Memory Usage: 41.3 MB, less than 5.61%
    * */
    public ListNode_Random copyRandomList2(ListNode_Random head){
        if(head == null) return null;
        /* First Pass. For each node from head to tail create new node and point it's next to the new node.
        The next of the new node will point to next node of original list.
         */
        ListNode_Random pointer = head;
        while(pointer != null){
            ListNode_Random temp = pointer.next;
            ListNode_Random newNode = new ListNode_Random(pointer.value);
            pointer.next = newNode;
            newNode.next = temp;
            pointer = temp; // don't type pointer.next. You already modified pointer.next.
        }
        /* Second pass. Assign the random pointers to the newly created clone nodes.

         */
        pointer = head;
        while (pointer != null){
            if(pointer.random != null)
                pointer.next.random = pointer.random.next;
            else
                pointer.next.random = null;
            pointer = pointer.next.next;
        }

        /* Third pass. The first pass made all the next pointers of the given node point to new clones fix that.
            Also fix the next pointer of the cloned nodes to point to next clone nodes.
         */
        pointer = head;
        ListNode_Random newHead = pointer.next;
        ListNode_Random pointer2 = newHead;
        while (pointer != null){
            ListNode_Random temp = pointer.next.next;
            pointer.next = temp;
            if(temp == null) /* Handling the temp to be null here is very important here */
                pointer2.next = null;
            else
                pointer2.next = temp.next;
            pointer = temp;
            if(temp == null) /* Handling the temp to be null here is very important here */
                pointer2 = null;
            else
                pointer2 = temp.next;
        }

        return newHead;
    }
    public static void main(String[] args){
        ListNode_Random head = new ListNode_Random(1);
        head.next = new ListNode_Random(2);
        head.next.next = new ListNode_Random(3);
        head.next.next.next = new ListNode_Random(4);
        head.next.next.next.next = new ListNode_Random(5);
        head.next.next.next.next.next = new ListNode_Random(6);
        head.next.next.next.next.next.next = new ListNode_Random(7);

        head.random = null; // 1 - null;
        head.next.random = head.next.next; // 2 -> 3
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next.next.next.next; // 4 -> 6
        head.next.next.next.next.random = head.next.next.next.next.next.next; // 5 -> 7
        head.next.next.next.next.next.random = null; // 6 -> null
        head.next.next.next.next.next.next.random = head; // 7 -> null
        CopyListWithRandomPointer cp = new CopyListWithRandomPointer();
        ListNode_Random newCopy1 = cp.copyRandomList(head);
        ListNode_Random temp = head;
        while(temp != null){
            if(temp.random != null)
                System.out.print(temp.value + " -> " + temp.random.value + ", ");
            else
                System.out.print(temp.value + " - > null, ");
            temp = temp.next;
        }
        System.out.println();
        while(newCopy1 != null){
            if(newCopy1.random != null)
                System.out.print(newCopy1.value + " -> " + newCopy1.random.value + ", ");
            else
                System.out.print(newCopy1.value + " - > null, ");
            newCopy1 = newCopy1.next;
        }
        System.out.println();
        ListNode_Random temp2 = cp.copyRandomList2(head);;

        while (temp2 != null){
            System.out.print(temp2.value + " , ");
            temp2 = temp2.next;
        }
    }
}
