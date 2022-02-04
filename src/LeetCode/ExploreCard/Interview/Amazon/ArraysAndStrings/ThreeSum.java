package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
import java.util.*;
/*
    Sort the array at O(N log N) cost. 2 Sum can be solved in O(N) without sort but
    for 3 sum best run time is O(N log N)
 */
public class ThreeSum {
    /*
        Runtime: 21 ms
        Memory Usage: 43.6 MB
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> _3sum = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            // remove duplicates
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if( -(nums[left] + nums[right]) == nums[i]) {
                    _3sum.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]) left++; // remove duplicates
                    while (left < right && nums[right] == nums[right + 1]) right--; // remove duplicates
                }
                else if( -(nums[left] + nums[right]) < nums[i]) right--;
                else left++;
            }
        }
        return _3sum;
    }
}
