package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
    Problem No. 55.
    Dynamic Programming.
 */
public class JumpGame {

    int[] canJumpTable;
    /* Runtime: 861 ms, faster than 8.70%
        Memory Usage: 44 MB, less than 9.40%
     */
    public boolean canJump(int[] nums){
        canJumpTable = new int[nums.length];
        canJumpTable[nums.length - 1] = 1;
        return jumps(0, nums);
    }
    public boolean jumps(int position, int[] nums){
        if(canJumpTable[position] != 0)
            return canJumpTable[position] == 1;
        int farthestJum = Math.min(nums.length - 1, position + nums[position]);
        for(int nextPosition = farthestJum; nextPosition > position; nextPosition--){
            if(jumps(nextPosition, nums)){
                canJumpTable[position] = 1;
                return true;
            }
        }
        canJumpTable[position] = -1;
        return false;
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 1, 1, 4};
        //int[] nums = {3, 2, 1, 0, 4};
        //int[] nums = {0};
        //int[] nums = {1};
        //int[] nums = {2, 0};
        //int[] nums = {4, 3 , 1, 1, 0, 10};
        //int[] nums = {2, 5, 0, 0};
        //int[] nums = {4, 3, 1, 1, 8};
        //int[] nums = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        JumpGame jg = new JumpGame();
        System.out.println("I can get to the last index " + jg.canJump(nums));
    }
}
