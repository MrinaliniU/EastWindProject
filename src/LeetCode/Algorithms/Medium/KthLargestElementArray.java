package LeetCode.Algorithms.Medium;

import java.util.*;

public class KthLargestElementArray {
    /*
        O(N LOG N)
        Runtime: 2 ms, faster than 76.95%
        Memory Usage: 39.7 MB, less than 5.18%
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    /*
        The time complexity of adding an element in a heap of size k is
        O(LOG K), and we do it N times that means O(N LOG K) time complexity for the algorithm.
        O(N LOG K)
        Runtime: 4 ms, faster than 63.02%
        Memory Usage: 39.7 MB, less than 5.18%
     */
    public int findKthLargest2(int[] nums, int k) {
        // The priority queue keeps the smallest element front
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : nums){
            heap.add(n);
            // the below check makes sure the queue always holds kth largest in the front of the queue
            if(heap.size() > k) heap.poll();
        }
        return heap.poll();
    }
}
