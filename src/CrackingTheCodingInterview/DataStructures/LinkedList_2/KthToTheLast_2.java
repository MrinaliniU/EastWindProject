package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

public class KthToTheLast_2 {

    /* This is when you are allowed to find the length of the list */
    public ListNode<String> kthElementToLast(ListNode<String> head, int k){
        ListNode<String> pointer = head;
        int len = 0;
        while(pointer != null){
            len++;
            pointer = pointer.next;
        }
        int kthElement = (len - k);
        pointer = head;
        while (kthElement != 0){
            kthElement--;
            pointer = pointer.next;
            if(pointer == null) break;
        }
        return pointer;
    }
    /* When you are not allowed to find the length of the list it can be solved both using recursion and
    iterative method.
     */
    public ListNode<String> kthElementToLast_recursive(ListNode<String> head, int k){
        return recurse(head, k, 0).answerNode;
    }
    public Wrapper recurse(ListNode<String> node, int k, int currentLength){
        if(node == null){
            Wrapper ws = new Wrapper();
            ws.length = currentLength;
            return ws;
        }
        Wrapper w = recurse(node.next, k, currentLength + 1);
        if(w.length - currentLength == k){
            w.answerNode = node;
        }
        return w;
    }
    static class Wrapper{
        ListNode<String> answerNode;
        int length;
    }
    public static void main(String[] args){
        KthToTheLast_2 k2 = new KthToTheLast_2();
        int k = 3;
        ListNode<String> l1 = new ListNode<>("A");
        l1.next = new ListNode<>("B");
        l1.next.next = new ListNode<>("C");
        l1.next.next.next = new ListNode<>("D");
        l1.next.next.next.next = new ListNode<>("E");
        l1.next.next.next.next.next = new ListNode<>("F");
        l1.next.next.next.next.next.next = new ListNode<>("G");
        l1.next.next.next.next.next.next.next = new ListNode<>("H");
        l1.next.next.next.next.next.next.next.next = new ListNode<>("I");
        ListNode<String> ans1 = k2.kthElementToLast(l1, k);
        if(ans1 != null)
            System.out.println(k + " rd/th element to last is " + ans1.value);
        else
            System.out.println("The list is shorter than k");
        ListNode<String> ans2 = k2.kthElementToLast_recursive(l1, k);
        if(ans2 != null)
            System.out.println(k + " rd/th element to last is " + ans2.value);
        else
            System.out.println("The list is shorter than k");
    }
}
