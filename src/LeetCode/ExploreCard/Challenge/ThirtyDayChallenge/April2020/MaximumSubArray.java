package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
    Problem No. 53.
 */
public class MaximumSubArray {
    /*
        From index 1 the question to be asked at each current digit is that should I add this current digit
        to the previously calculated sum or should I start a new sub-array calculation from current digit?
        if current digit is larger than current digit + previous sum then start from current digit or update the
        calculated sum to current digit + calculated sum
     */
/* Using two variables consumed more memory than using one memo array, need to find why, (40 MB)*/
/*    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int solution = nums[0];
        int calculatedSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            calculatedSum = Math.max(calculatedSum + nums[i], nums[i]);
            if(calculatedSum > solution) solution = calculatedSum;
        }
        return solution;
    }*/
/* Runtime: 0 ms, faster than 100.00%
* Memory Usage: 39.1 MB, less than 9.86%
* */

    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] n = new int[nums.length];
        n[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            n[i] = Math.max(n[i - 1] + nums[i], nums[i]);
        }
        int sol = Integer.MIN_VALUE;
        for(int i : n){
            if(i > sol) sol = i;
        }
        return sol;
    }
    /* Runtime: 1 ms, faster than 84.37%
    Memory Usage: 39 MB, less than 12.20%
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {10, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {1, 2, 3, -1, 5, 6, 7, 8};
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-1, -2};
        //int[] nums = {1};
        //int[] nums = {-1};
        MaximumSubArray ms = new MaximumSubArray();
        System.out.println("Maximum sum " + ms.maxSubArray(nums));
    }
}
