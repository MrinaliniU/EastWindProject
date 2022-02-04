package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

import java.util.*;

public class TopKFrequentElements {
    /*
        Runtime: 11 ms
        Memory Usage: 42.1 MB
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> num_count = new HashMap<>();
        for(int num : nums) num_count.put(num, num_count.getOrDefault(num, 0) + 1);
        ArrayList<Integer> topFrequentCandidates = new ArrayList<>(num_count.keySet());
        topFrequentCandidates.sort((a, b) -> num_count.get(b) - num_count.get(a));
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) result[i] = topFrequentCandidates.get(i);
        return result;
    }
    public static void main(String[] args){
        TopKFrequentElements tk = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.print(Arrays.toString(tk.topKFrequent(nums, 2)));
    }
}
