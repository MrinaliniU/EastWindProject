package LeetCode.Algorithms.Easy;

/*
    Problem No. 448.
    Using Arrays.sort() increases the run-time.
 */

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    /*
        By far the fastest.
        5 ms, faster than 90.22%.
        48.4 MB, less than 35.85%.
     */
    public List<Integer> swappingMethod(int[] nums){
        List<Integer> solution = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }else{
                i++;
            }
        }
        for(int a = 0; a < nums.length; a++){
            if(nums[a] != a + 1)
                solution.add(a + 1);
        }
        return solution;
    }

    /*
        Runtime: 24 ms, faster than 22.46%
        Memory Usage: 48.5 MB, less than 33.96%
     */
    public List<Integer> binarySearchMethod(int[] nums){
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(nums);
        int n = 1;
        while(n <= nums.length){
            int sol = Arrays.binarySearch(nums, n++);
            if(0 > sol)
                solution.add(n - 1);
        }
        return solution;
    }
    /*
        Runtime: 17 ms, faster than 27.94%
        Memory Usage: 48.4 MB, less than 33.96%
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        ArrayList<Integer> solution = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int n = 1;
        for(int i = 0; i < len; i++){
            if(n > len)
                break;
            while (nums[i] > n){
                solution.add(n);
                n++;
            }
            if(nums[i] == n)
                n++;
            if(i == len - 1 && n <= len){
                while(n <= len){
                    solution.add(n);
                    n++;
                }
            }
        }
        return solution;
    }
    public static void main(String[] args){
        //int[] nums = {1, 1, 2, 2};
        //int[] nums = {1, 1};
        //int[] nums = {10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        //int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums = {4, 3, 2, 7, 7, 2, 3, 1};
        FindAllNumbersDisappearedInAnArray fd = new FindAllNumbersDisappearedInAnArray();
        List<Integer> solution = fd.swappingMethod(nums);
        for(int a : solution){
            System.out.print(a + " ");
        }
    }
}
