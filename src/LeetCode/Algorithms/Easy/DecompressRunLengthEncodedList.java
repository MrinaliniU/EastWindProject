package LeetCode.Algorithms.Easy;

import java.util.*;

public class DecompressRunLengthEncodedList {
    /*
        Runtime: 1 ms, faster than 95.63%
        Memory Usage: 45.8 MB, less than 100.00%
     */
    public int[] arraysFillMethod(int[] nums) {
        int resultLength = 0;
        for(int i = 0; i < nums.length; i = i + 2)
            resultLength += nums[i];
        int[] result = new int[resultLength];
        for(int i = 0, index = 0; i < nums.length - 1; i = i + 2){
            Arrays.fill(result, index, index + nums[i], nums[i + 1]);
            index += nums[i];
        }
        return result;
    }
    /*
        Runtime: 7 ms, faster than 9.30%
        Memory Usage: 46.5 MB, less than 100.00%
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> r = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i = i + 2){
            while (nums[i] > 0) {
                r.add(nums[i + 1]);
                nums[i] -= 1;
            }
        }
        int[] result = new int[r.size()];
        for(int i = 0; i < r.size(); i++) result[i] = r.get(i);
        return result;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        DecompressRunLengthEncodedList r = new DecompressRunLengthEncodedList();
        int[] result = r.arraysFillMethod(arr);
        for(int i : result) System.out.print(i + " ");
    }
}
