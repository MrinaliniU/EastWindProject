package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.Arrays;

// NO DIVISION ALLOWED.
// nums can contain 0 and dividing by 0 gives Arithmetic Exception
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf1(int[] nums) {
      int[] result = new int[nums.length];
        int[] left = new int[nums.length]; left[0] = 1; // first element has nothing to it's left
        int[] right = new int[nums.length]; right[right.length - 1] = 1;// last element has nothing on it's right
        /* Fill in left array such that at any left[i] is product of all elements before index i */
        for(int i = 1; i < left.length; i++)
            left[i] = left[i - 1] * nums[i - 1];
        for(int i = right.length - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];
        for(int i = 0; i < result.length; i++)
            result[i] = left[i] * right[i];
        return result;
    }
    /* save some space */
    /*
        Runtime: 1 ms
        Memory Usage: 47.8 MB
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; result[0] = 1; // result is filled as the left product array
        int right = 1;
        /* Fill in left array such that at any left[i] is product of all elements before index i */
        for(int i = 1; i < result.length; i++)
            result[i] = result[i - 1] * nums[i - 1];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
        // int[] nums = {0, 0};
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ps.productExceptSelf(nums)));
    }
}
