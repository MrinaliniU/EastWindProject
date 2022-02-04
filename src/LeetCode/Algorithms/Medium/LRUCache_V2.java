package LeetCode.Algorithms.Medium;

import java.util.*;

// TODO: 3/12/2020 #MyInterviews.Microsoft
public class LRUCache_V2 {
    /* Runtime: 11 ms, faster than 99.96%
    Memory Usage: 50.6 MB, less than 96.93%
    */
    private int capacity;
    LinkedHashMap<Integer, Integer> lruMap;
    LRUCache_V2(int capacity){
        this.capacity = capacity;
        this.lruMap = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key){
        return this.lruMap.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        this.lruMap.put(key, value); // this could be an update
        if (this.lruMap.size() > this.capacity)
            this.lruMap.remove(this.lruMap.entrySet().iterator().next().getKey());
        // remove only if the newly added entry increases the LRUCapacity.
    }

    public static void main(String[] args){
        LRUCache_V2 cache = new LRUCache_V2(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(1, 11);
        cache.put(3, 30);
        System.out.println(cache.lruMap);
    }
}
