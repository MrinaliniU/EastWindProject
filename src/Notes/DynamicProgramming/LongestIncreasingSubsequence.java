package Notes.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /* n^2 runtime */
    public int longestIncreasingSubsequence(int[] array){
        int[] storeSequenceLength = new int[array.length];
        Arrays.fill(storeSequenceLength, 1);
        int solution = 0;
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i])
                    storeSequenceLength[i] = Math.max(storeSequenceLength[j] + 1, storeSequenceLength[i]);
            }
        }
        for(int sol : storeSequenceLength){
            if(sol > solution)
                solution = sol;
        }
        return solution;
    }

    /* O(N Log N) runtime. */

    public static void main(String[] args){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        //int[] array = {2, 2, 1, 8, 3, 2, 2, 4, 2};
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // -2, 1, 4, 4. See how duplicates increases the length.
        //int[] array = {1, 2};
        //int[] array = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        System.out.println("Longest increasing subsequence is " + lis.longestIncreasingSubsequence(array));
    }
}
