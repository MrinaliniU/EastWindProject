package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;

import java.util.*;

public class CopyListWithRandomPointer {
    static class Node{
        Node next;
        Node random;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    /*
        Runtime: 0 ms
        Memory Usage: 39.4 MB
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node mapPointer = head;
        /* First Pass. For each node in original list create a new node and map them */
        while (mapPointer != null){
            map.put(mapPointer, new Node(mapPointer.val));
            mapPointer = mapPointer.next;
        }
        mapPointer = head;
        /* Second pass. Using the map connect all the next pointer */
        while (mapPointer != null){
            map.get(mapPointer).next = map.get(mapPointer.next);
            mapPointer = mapPointer.next;
        }
        /* Third Pass. Using map connect all the random pointer */
        mapPointer = head;
        while (mapPointer != null){
            /* mapPointer.random could be null but it's safe here because map.get(null) returns null*/
            map.get(mapPointer).random = map.get(mapPointer.random);
            mapPointer = mapPointer.next;
        }
        mapPointer = head;
        return map.get(mapPointer);
    }
    /*
        Runtime: 0 ms
        Memory Usage: 39.2 MB
     */
    public Node copyRandomList_space(Node head){
        if(head == null) return null;
        /* First Pass for every node create a new node and point the next of original node this node
        * connect the next of this node to the next of the original node */
        Node pointer = head;
        while (pointer != null){
            Node temp = pointer.next;
            pointer.next = new Node(pointer.val);
            pointer.next.next = temp;
            pointer = temp;
        }
        /* Second pass. Connect the random pointers*/
        pointer = head;
        while (pointer != null){
            if(pointer.random != null)
                pointer.next.random = pointer.random.next;
            pointer = pointer.next.next; // this is safe because of the new node created in first pass.
        }
        /* Third pass. Now fix next pointer of original list and next pointer of new list */
        pointer = head;
        Node newHead = pointer.next;
        Node pointer2 = newHead;
        while (pointer != null){
            Node temp = pointer.next.next;
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
        CopyListWithRandomPointer cp = new CopyListWithRandomPointer();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.random = head;
        Node newHead = cp.copyRandomList_space(head);
        System.out.println("Print original head");
        while (head != null){
            if(head.random != null)
                System.out.print(head.val + "(" + head.random.val + ")" + " ");
            else
                System.out.print(head.val + "(null)" + " ");
            head = head.next;
        }
        System.out.println();
        System.out.println("Print new head");
        while (newHead != null){
            if(newHead.random != null)
                System.out.print(newHead.val + "(" + newHead.random.val + ")" + " ");
            else
                System.out.print(newHead.val + "(null)" + " ");
            newHead = newHead.next;
        }
    }
}
