package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

public class DeleteMiddleNode_3 {

    public void deleteGivenNode(ListNode node){
        // this logic won't work if node to delete is tail node.
        if(node != null && node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }
}
