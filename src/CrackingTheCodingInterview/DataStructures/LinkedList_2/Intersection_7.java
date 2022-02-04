package CrackingTheCodingInterview.DataStructures.LinkedList_2;

import Notes.DataStructures.ListNode;

public class Intersection_7 {
    public ListNode findIntersection(ListNode l1, ListNode l2){
        int len1 = 0, len2 = 0;
        ListNode p1 = l1, p2 = l2;
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while (p2 != null){
            len2++;
            p2 = p2.next;
        }
        p1 = l1; p2 = l2;
        int diffLen = Math.abs(len1 - len2);
        if(len1 > len2){
            while(diffLen != 0){
                p1 = p1.next;
                diffLen--;
            }
        }else if (len2 > len1){
            while(diffLen != 0){
                p2 = p2.next;
                diffLen--;
            }
        }
        while (p1 != null && p2 != null){
            if(p1 == p2)
                break;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    /* One way to make the logic a little better here is that when you check for the length of the
     * two lists when you reach the last node of both list and they are different nodes then it means that
     * there is no intersection. If that is the case we can return null before trying to find an intersection.*/
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(6);
        l2.next.next.next = l1.next.next;

        Intersection_7 i7 = new Intersection_7();
        System.out.println("Intersection at " + i7.findIntersection(l1, l2).value);
    }
}
