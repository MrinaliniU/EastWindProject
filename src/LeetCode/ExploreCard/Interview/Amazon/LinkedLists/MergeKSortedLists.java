package LeetCode.ExploreCard.Interview.Amazon.LinkedLists;

import java.util.*;
public class MergeKSortedLists {
    /*
        Runtime: 1 ms
        Memory Usage: 40.9 MB
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        int amount = lists.length;
        int interval = 1;
        while (interval < amount){
            for(int i = 0; i < amount - interval; i += interval * 2){
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
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
        Brute Force.
        Runtime: 7 ms, faster than 26.51%
        Memory Usage: 40.4 MB, less than 59.02%
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> allNums = new ArrayList<>();
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        for(ListNode head : lists){
            while (head != null) {
                allNums.add(head.val);
                head = head.next;
            }
        }
        allNums.sort(Integer::compareTo); // sorting O(N log N) most expensive
        for(Integer i : allNums) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }
        return result.next;
    }

    public static void main(String[] args){
        MergeKSortedLists mk = new MergeKSortedLists();
        ListNode h1 = null;
        ListNode h2 = new ListNode(-1);
        h2.next = new ListNode(5);
        h2.next.next = new ListNode(11);
        ListNode h3 = null;
        ListNode h4 = new ListNode(6);
        h2.next = new ListNode(10);
        ListNode[] lists = new ListNode[4];
        lists[0] = h1;
        lists[1] = h2;
        lists[2] = h3;
        lists[3] = h4;
        ListNode result = mk.mergeKLists(lists);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
