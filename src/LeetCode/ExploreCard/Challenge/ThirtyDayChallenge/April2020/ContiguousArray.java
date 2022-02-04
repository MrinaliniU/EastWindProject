package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.HashMap;
/*
    Runtime: 20 ms
    Memory Usage: 49.3 MB
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int count = 0;
        int max = 0;
        HashMap<Integer, Integer> count_index = new HashMap<>();
        count_index.put(0, -1); // important for int[] nums = {0, 1};
        for(int i = 0; i < nums.length; i++){
            count += nums[i] == 0 ? -1 : 1;
            if(count_index.containsKey(count)) max = Math.max(max, i - count_index.get(count));
            else count_index.put(count, i);
        }
        return max;
    }

    public static void main(String[] args){
        // int[] nums = {0, 1, 0, 0, 1, 1, 0};
        int[] nums = {0, 1};
        ContiguousArray ca = new ContiguousArray();
        System.out.println("Max len " + ca.findMaxLength(nums));
    }
}
