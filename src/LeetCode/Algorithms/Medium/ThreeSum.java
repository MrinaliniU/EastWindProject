package LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
        Runtime: 20 ms, faster than 73.81%
        Memory Usage: 45.2 MB, less than 97.88%
     */
    public List<List<Integer>> threeSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i + 1 < nums.length && nums[i] == nums[i + 1]) continue; // this is to remove duplicate entries in the final result.
            int a = i + 1; int b = nums.length - 1;
            while(b < nums.length && a < b){
                if(nums[i] == -(nums[a] + nums[b])){
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[a], nums[b])));
                    a++;
                    b--;
                    while (a < b && nums[a] == nums[a - 1]) a++; // this is also to remove duplicates.
                    while (a < b && nums[b] == nums[b + 1]) b--; // to remove duplicates.
                }
                else if(nums[i] < -(nums[a] + nums[b])){
                    a++;
                }else{
                    b--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        // int[] nums = {0, 0, 0, 0};
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0 ,0 , 2, 2};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum(nums, 0);
        for(List<Integer> i : result){
            System.out.println(i);
        }
    }
}
