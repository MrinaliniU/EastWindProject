package LeetCode.Algorithms.Medium;

/*
    Problem No. 75
 */
public class SortColors {

    /* Runtime: 0 ms, faster than 100.00%
    * Memory Usage: 38.2 MB, less than 5.51%*/
    public void sortColors(int[] nums){
        int zero = 0, two = nums.length - 1, current = 0;
        while (current <= two){
            if(nums[current] == 0) swap(nums, zero++, current++);
            else if(nums[current] == 2) swap(nums, two--, current);
            else current++;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] input = {0, 1, 0, 0, 1, 1, 2, 0, 2, 1, 2, 0};
        SortColors sc = new SortColors();
        sc.sortColors(input);
        for(int a : input){
            System.out.print(a + " ");
        }

    }
}
