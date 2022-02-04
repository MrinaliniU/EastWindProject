package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.HashMap;

/* Problem No. 169 */
public class MajorityElement {

    /*
        Runtime: 1 ms, faster than 99.86%
        Memory Usage: 42.6 MB, less than 58.82%
     */
    public int votingAlgorithmBoyerMoore(int[] nums){
        int count = 0;
        int candidate = 0;
        for(int num : nums){
            if(count == 0) candidate = num;
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
    /*
        Runtime: 7 ms, faster than 47.14%
        Memory Usage: 45 MB, less than 5.15%
     */
    public int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int count = map.getOrDefault(num, 0);
            if(count >= nums.length / 2) return num;
            map.put(num, count + 1);
        }
        return 0;
    }
    public static void main(String[] args){
        int[] nums = {2, 2, 3, 3, 3, 3, 3, 3, 5, 5};
        MajorityElement me = new MajorityElement();
        System.out.println("The majority element is " + me.majorityElement(nums));
    }
}
