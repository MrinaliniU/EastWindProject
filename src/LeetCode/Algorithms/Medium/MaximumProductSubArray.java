package LeetCode.Algorithms.Medium;

/*
    Problem No. 152.
 */
public class MaximumProductSubArray {
    /*
        Runtime: 1 ms, faster than 98.65%
        Memory Usage: 39 MB, less than 9.76%
     */
    public int maxProduct(int[] nums){
        int previous_max = nums[0];
        int previous_min = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curr_max = Math.max(previous_max * nums[i], Math.max(previous_min * nums[i], nums[i]));
            int curr_min = Math.min(previous_max * nums[i], Math.min(previous_min * nums[i], nums[i]));
            ans = Math.max(ans, curr_max);
            previous_max = curr_max;
            previous_min = curr_min;
        }
        return ans;
    }
    public static void main(String[] args){
        int nums[] = {2, 3, -2, 4};
        //int nums[] = {-2, 0, -1};
        //int nums[] = {-2, 1, 3, -1, 2};
        // int nums[] = {-2, 3, -4};
        // int nums[] = {-2, 3, -2, 4};
        //int nums[] = {2, 3, -2, 4};
        //int nums[] = {-4, -3, -2};
        MaximumProductSubArray ms = new MaximumProductSubArray();
        System.out.println("Maximum Product " + ms.maxProduct(nums));
    }
}
