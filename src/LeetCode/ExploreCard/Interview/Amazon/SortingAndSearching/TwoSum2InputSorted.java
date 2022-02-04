package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

import java.util.Arrays;
/*
    Runtime: 0 ms
    Memory Usage: 40 MB
 */
public class TwoSum2InputSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right){
            if(target == numbers[left] + numbers[right]) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            else if(target < numbers[left] + numbers[right])
                right--;
            else left++;
        }
        return result;
    }
    public static void main(String[] args){
        TwoSum2InputSorted ts = new TwoSum2InputSorted();
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.print(Arrays.toString(ts.twoSum(numbers, target)));
    }
}
