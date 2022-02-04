package LeetCode.Algorithms.Easy;
/*
    Problem No. 581.
 */

import java.util.*;

public class ShortestUnsortedContinuousSubArray {

    /*
        Runtime: 5 ms, faster than 59.54%
        Memory Usage: 41.1 MB, less than 69.23%
     */
    public int findUnsortedSubArray(int[] nums){
        int[] newNums = nums.clone(); // O(n) space
        Arrays.sort(nums); // Sorting takes n log n time.
        int i = 0, j = nums.length - 1;
        /*
            important to have i <= j and j >= i conditions before
            using them for nums[i/j] to avoid index out of bound exception.
         */
        while(i <= j && nums[i] == newNums[i] ) i++;
        while(j >= i && nums[j] == newNums[j]) j--;
        return j - i + 1;
    }

    /*
        Other LeetCode Solutions
     */

    public int bruteForce(int[] nums) { // O(n^2)
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    /*
        Time complexity : O(n)O(n). Stack of size nn is filled.
        Space complexity : O(n)O(n). Stack size grows upto nn.
     */
    public int stackSolution(int[] nums) {
        Stack< Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    /*
        Time complexity : O(n)O(n). Four O(n)O(n) loops are used.
        Space complexity : O(1)O(1). Constant space is used.
     */
    public int spaceEfficient(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
    public static void main(String[] args){
        ShortestUnsortedContinuousSubArray s = new ShortestUnsortedContinuousSubArray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        //int[] nums = {1, 2, 3, 10, 4, 5, 6};
        //int[] nums = {1, 2, 3, 4};
        System.out.println("The un-sorted array length is " + s.findUnsortedSubArray(nums));
    }
}
