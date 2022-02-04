package LeetCode.Algorithms.Easy;

public class NumbersSmallerThanCurrentNumber {
    /*
        Funcky solution by leetcoder
        Runtime: 2 ms, faster than 82.09%
        Memory Usage: 41.7 MB, less than 100.00%
     */
    public int[] smallerNumbersThanCurrent(int[] nums){
        int[] frequency_store = new int[101]; // numbers can range from 0 to 100;
        int[] result = new int[nums.length];
        for(int i : nums) frequency_store[i]++;
        int smallestNumbers = 0; //
        for(int i = 0; i < frequency_store.length; i++){
            if(frequency_store[i] == 0) continue;
            int current_frequency = frequency_store[i];
            frequency_store[i] = smallestNumbers;
            smallestNumbers += current_frequency;
        }
        for(int i = 0; i < result.length; i++) result[i] = frequency_store[nums[i]];
        return result;
    }
    /*
        Runtime: 17 ms, faster than 6.66%
     */
    public int[] slowShit(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i  < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < nums[i]) result[i] += 1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        NumbersSmallerThanCurrentNumber c = new NumbersSmallerThanCurrentNumber();
        int[] nums = {8, 1, 2, 2, 4, 5, 0, 0, 0};
        for(int i : c.smallerNumbersThanCurrent(nums)){
            System.out.print(i + " ");
        }
    }
}
