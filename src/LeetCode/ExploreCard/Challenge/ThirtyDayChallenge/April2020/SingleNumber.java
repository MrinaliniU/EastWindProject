package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Solution:
    If we take XOR of zero and some bit, it will return that bit
        a XOR 0 = a
    If we take XOR of two same bits, it will return 0
        a XOR a = 0
        a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b
Problem No. 136.
 */
public class SingleNumber {

    public int singleNumber(int[] nums){
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }

    public int singleNumber2(int[] nums){
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 2, 1, 3};
        SingleNumber sn = new SingleNumber();
        System.out.println("The unique number is " + sn.singleNumber2(nums));
    }
}
