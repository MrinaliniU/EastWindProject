package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

public class MoveZeros {
    /* 100% faster than all java solution
    * Problem No. 283. */

    public void moveZeroes(int[] nums){
        int nonZeroIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) {
                nonZeroIndex++;
                swap(nums, nonZeroIndex, i);
            }
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args){
        MoveZeros mz = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {1, 2, 0, 0, 5, 0, 6, 7, 8, 0, 0};
        mz.moveZeroes(nums);
        mz.moveZeroes(nums2);
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : nums2){
            System.out.print(i + " ");
        }
    }
}
