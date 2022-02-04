package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        for(int num : nums){
            x ^= num;
        }
        return x;
    }
}
