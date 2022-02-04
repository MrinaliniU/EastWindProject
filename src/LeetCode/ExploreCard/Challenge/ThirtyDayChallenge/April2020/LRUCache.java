package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.*;

public class LRUCache {
    private final Map<Integer, ListNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final ListNode head;
    private final ListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    static class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;
    }
    private void addNode(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private ListNode removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    private void update(ListNode node, int value){
        node.value = value;
        moveToHead(node);
    }
    private void moveToHead(ListNode node){
        removeNode(node);
        addNode(node);
    }
    private void addNewNode(int key, int value){
        ListNode newNode = new ListNode();
        newNode.key = key;
        newNode.value = value;
        cache.put(key, newNode);
        addNode(newNode);
        ++size;
        if(size > capacity) {
            cache.remove(removeTail().key);
            --size;
        }
    }
    private ListNode removeTail() {
        return removeNode(tail.prev);
    }
    /* ACTUAL EXPOSED FUNCTION */
    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if(node == null) addNewNode(key, value);
        else update(node, value);
    }
}
