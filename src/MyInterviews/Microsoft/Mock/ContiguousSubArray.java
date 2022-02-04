package MyInterviews.Microsoft.Mock;
/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class ContiguousSubArray {

    public int longestSumSubArray(int[] array){
        int max = 0;
        int[] memo = new int[array.length];
        for(int i = 0; i < array.length; i++){
            max = Math.max(max + array[i], array[i]);
            memo[i] = max;
        }
        int solution = Integer.MIN_VALUE;
        for(int s : memo){
            if(s > solution) solution = s;
        }
        return solution;
    }
    public static void main(String[] args){
        ContiguousSubArray ca = new ContiguousSubArray();
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Longest sum " + ca.longestSumSubArray(input));
    }
}
