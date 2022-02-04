package Practice;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }


    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> nums = Arrays.asList(1, 2, 7, 4, 5, 6, 3, 8);
        s.findTwoSwapped(nums);
    }
}
