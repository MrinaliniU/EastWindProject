package LeetCode.Algorithms.Easy;

/*
    Problem No. 198.
    Dynamic Programming.
    -- Modified Power set in disguise --
 */
public class HouseRobber {

    /*
        For each house you are deciding either
            1. Stealing from it and skipping the next house OR
            2. Skipping the current house and making decision at 1. again at the next house.
     */
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 37 MB, less than 5.26%
     */
    public int rob(int[] nums){
        if(nums.length == 1) return nums[0];
        int sol = 0;
        int p = 0;
        int q = nums[0];
        for(int i = 1; i < nums.length; i++){
            sol = Math.max(nums[i] + p, q);
            p = q;
            q = sol;
        }
        return sol;
    }

    public static void main(String[] args){
        int[] street1 = {2, 7, 9, 3, 1};// 12
        int[] street2 = {1, 2, 3, 1}; // 4
        int[] street3 = {1}; // 1
        int[] street4 = {1, 2, 3, 4, 5, 6}; // 12
        int[] street5 = {2, 1, 1, 2};// 4
        int[] street6 = {13, 2, 1, 4, 1, 6};// 23
        int[] street7 = {2, 3, 1, 2}; // 5
        HouseRobber hr = new HouseRobber();
        System.out.println("Maximum money robbed at street 1 is: " + hr.rob(street1));
        System.out.println("Maximum money robbed at street 2 is: " + hr.rob(street2));
        System.out.println("Maximum money robbed at street 3 is: " + hr.rob(street3));
        System.out.println("Maximum money robbed at street 4 is: " + hr.rob(street4));
        System.out.println("Maximum money robbed at street 5 is: " + hr.rob(street5));
        System.out.println("Maximum money robbed at street 6 is: " + hr.rob(street6));
        System.out.println("Maximum money robbed at street 7 is: " + hr.rob(street7));

    }
}
