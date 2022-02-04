package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class MaximumSumCircularSubarray {
    /*
        This takes O(N) runtime
        Runtime: 2 ms, faster than 100.00%
        Memory Usage: 45.6 MB, less than 10.00%
     */
    public int maxSubarraySumCircular(int[] A) {
        int regularArrayKadane = kadane(A);
        int totalSumA = 0;
        /* invert sign of A and Invert sign of A */
        for(int i = 0; i < A.length; i++) {
            totalSumA += A[i];
            A[i] = -A[i];
        }
        int circularArrayKadane = totalSumA + kadane(A);
        if(circularArrayKadane <= 0) return regularArrayKadane;
        return Math.max(circularArrayKadane, regularArrayKadane);
    }

    public int kadane(int[] A){
        int previous = A[0], solution = A[0];
        for(int i = 1; i < A.length; i++){
            previous = A[i] + Math.max(previous, 0);
            solution = Math.max(solution, previous);
        }
        return solution;
    }

    /* This is my solution but runtime is O(N^2) */

    public int maxSubarraySumCircular2(int[] A) {
        int solution = Integer.MIN_VALUE;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            solution = Math.max(solution, kadane(A, i, len));
        }
        return solution;
    }

    public int kadane(int[] A, int startIndex, int len) {
        int solution = A[0], previous_maxSum = A[0];
        for (int i = startIndex + 1; i < len + startIndex; i++) {
            previous_maxSum = A[i % len] + Math.max(previous_maxSum, 0);
            solution = Math.max(previous_maxSum, solution);
        }
        return solution;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray mc = new MaximumSumCircularSubarray();
        // int[] A = {-2}; System.out.print(mc.maxSubarraySumCircular(A)); // -2
        // int[] A = {1, -2, 3, -2}; mc.maxSubarraySumCircular(A); // 3
         int[] A = {5,-3,5}; System.out.print(mc.maxSubarraySumCircular(A)); // 10
        // int[] A = {3,-1,2,-1}; mc.maxSubarraySumCircular(A); // 4
        // int[] A = {3,-2,2,-3}; mc.maxSubarraySumCircular(A); // 3
        // int[] A = {-2,-3,-1}; mc.maxSubarraySumCircular(A); // -1
    }
}
