package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
/*
    This is kind of a stupid problem but has interesting solutions.
    An array is given with length n. The array is filled with elements in the range 0 - n.
    Note that since array of size n can be filled with 0 - (n-1) numbers
    and since we are allowed to pick 0 to n both are inclusive.
    It is inevitable that one number would be missing.
    Find that missing number.
    n = 1   [0] 1 is missing.
            [1] 0 is missing.
    n = 3   [0 1 2] 3 is missing.
            [1 2 3] 0 is missing.
 */
public class MissingNumber {
    /*
        Runtime: 0 ms
        Memory Usage: 40.1 MB
     */
    public int missingNumber(int[] nums) {
        // LeetCode uses HashSet here, which is slower that my solution here
        boolean[] holder = new boolean[nums.length + 1];
        // here it adds all the numbers to the set
        for(int i : nums) holder[i] = true;
        // here from 0 - n it checks if set has the expected number, if not it returns
        // hash set contains is O(1) operation so is checking a boolean array.
        for(int i = 0; i < holder.length; i++) if (!holder[i]) return i;
        return -1;
    }
    /* Bit manipulation.
    * Recall XOR a ^ a = 0
    *   - We know nums will have index 0 to (n - 1)
    *   - We know nums is supposed to have numbers picked from 0 - n
    *   - We know since there is no enough space there will be one number missing from 0 - n
    *   - Look at the following cases for n = 5
    *       0, 1, 2, 3, 4 --> 5 is missing
    *       0, 1, 2, 5, 4 --> 3 is missing
    *       1, 2, 3, 4, 5 --> 0 is missing
    *   Now for every case if we XOR the nums with 0 - n all the numbers that are in the
    *   array gets cancelled leaving out the number that is missing.
    *   Since n will give array out of bound for array length n. We keep that as a different variable n.
    * */
    public int missingNumber2(int[] nums) {
        int n = nums.length; // won't fall in rage of nums index
        // don't be an idiot and use i < n inside the for loop. You are modifying n.
        for(int i = 0; i < nums.length; i++) n ^= nums[i] ^ i;
        return n;
    }
    /* Solution using Gauss' Formula
    * Sum of 0 - n numbers is given by the formula (n * (n + 1)) / 2 .
    * */
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int expected_sum = (n * (n + 1)) / 2;
        int sum = 0;
        for(int i : nums) sum += i;
        return expected_sum - sum;
    }

    public static void main(String[] args){
        int[] nums = {0}; // 1
        int[] nums2 = {0, 1}; // 2
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1}; // 8
        MissingNumber mn = new MissingNumber();
        System.out.println("Missing number " + mn.missingNumber2(nums));
        System.out.println("Missing number " + mn.missingNumber2(nums2));
        System.out.println("Missing number " + mn.missingNumber2(nums3));
    }
}
