package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.HashMap;

public class SubarraySumEqualsK {
    /*
        HashMap
    Runtime: 11 ms
    Memory Usage: 40.6 MB
     */
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    /* Brute force O(n^2)
    *   Runtime: 203 ms
    Memory Usage: 39.8 MB */
    public int subarraySum2(int[] nums, int k) {
        int numOfSubArrays = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(temp == k) numOfSubArrays++;
            for(int j = i + 1; j < nums.length; j++){
                temp += nums[j];
                if(temp == k) numOfSubArrays++;
            }
        }
        return numOfSubArrays;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1}; // 2
        int[] nums2 = {100,1,2,3,100,1,2,3,4}; // 4
        int[] nums3 = {28,54,7,-70,22,65,-6}; // 1
        int[] nums4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 55
        int k = 2;
        int k2 = 3;
        int k3 = 100;
        int k4 = 0;
        SubarraySumEqualsK sk = new SubarraySumEqualsK();
        System.out.println(sk.subarraySum(nums, k ));
    }
}
