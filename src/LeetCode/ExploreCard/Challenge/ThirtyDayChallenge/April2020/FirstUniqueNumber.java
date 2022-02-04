package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

/*
    Runtime: 110 ms
    Memory Usage: 82.1 MB
 */
import java.util.*;
class ListNode{
    int val;
    ListNode prev, next;
    ListNode(int val){
        this.val = val;
    }
}
public class FirstUniqueNumber {
    ListNode uniqueList_head, uniqueList_tail;
    HashMap<Integer, ListNode> allNumbers;
    public FirstUniqueNumber(int[] nums) {
        allNumbers = new HashMap<>();
        uniqueList_head = new ListNode(-1);
        uniqueList_tail = new ListNode(-1);
        uniqueList_head.next = uniqueList_tail;
        uniqueList_tail.prev = uniqueList_head;
        for(int i : nums) this.add(i);
    }

    public int showFirstUnique() {
        return uniqueList_head.next.val;
    }

    public void add(int value) {
        // if allNumbers contains value means it is not unique
        if(allNumbers.containsKey(value) && allNumbers.get(value) != null){
            removeFromUniqueList(allNumbers.get(value));
            allNumbers.put(value, null);
            return;
        }
        if(!allNumbers.containsKey(value)) allNumbers.put(value, addToUniqueList(value));
    }
    private void removeFromUniqueList(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private ListNode addToUniqueList(int value){
        ListNode node = new ListNode(value);
        node.next = uniqueList_tail;
        node.prev = uniqueList_tail.prev;
        uniqueList_tail.prev.next = node;
        uniqueList_tail.prev = node;
        return node;
    }

    public static void main(String[] args){
        FirstUniqueNumber fu = new FirstUniqueNumber(new int[] {7, 7, 7, 7, 7, 7});
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(7);
        System.out.println(fu.showFirstUnique());
        fu.add(17);
        System.out.println(fu.showFirstUnique());
    }
}
