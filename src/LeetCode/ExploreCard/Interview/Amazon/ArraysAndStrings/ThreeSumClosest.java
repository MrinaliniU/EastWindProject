package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.*;

public class ThreeSumClosest {
    /*
        Runtime: 4 ms
        Memory Usage: 39 MB
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] sum_distance = {0, Integer.MAX_VALUE};
        for(int i = 0; i < nums.length - 2; i++){
            int a = i + 1, b = nums.length - 1;
            while(a < b){
                int sum = nums[i] + nums[a] + nums[b];
                if(sum == target) return sum;
                if(Math.abs(target - sum) < sum_distance[1]) {
                    sum_distance[0] = sum;
                    sum_distance[1] = Math.abs(target - sum);
                }
                if(sum < target) a++;
                else b--;
            }
        }
        return sum_distance[0];
    }

    public static void main(String[] args){
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(tsc.threeSumClosest(nums, 1));
    }
}
