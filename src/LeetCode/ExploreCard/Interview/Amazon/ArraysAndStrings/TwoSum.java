package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
import java.util.*;
public class TwoSum {
    /* Expects the index to be returned and not the values*/
    /* Two sum seems to have a trade off between space and time complexity, if you don't use a hashmap
    * then you will most likely use the nested for loop method resulting in worst case o(n^2) solution.*/
    /*
        o(n) time and o(n) space
        Runtime: 4 ms
        Memory Usage: 41.9 MB
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int index = 0; index < nums.length; index++){
            if(map.containsKey(target - nums[index])){
                result[1] = index;
                result[0] = map.get(target - nums[index]);
                return result;
            }
            map.put(nums[index], index);
        }
        return result;
    }


    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums, 9);
        System.out.println(result[0] + " : " + result[1]);
    }
}
