package LeetCode.StudyPlan.Algorithm1;

public class Day2_RotateArray {

    public void rotate(int[] nums, int k) {
        int n_len = nums.length;
        k %= n_len;
        int[] results = new int[n_len];
        int i = 0;
        while (k < n_len) {
            results[k++] = nums[i++];
        }
        int j = 0;
        while (i < n_len) {
            results[j++] = nums[i++];
        }
        for (int x = 0; x < n_len; x++) {
            nums[x] = results[x];
        }
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3};
        // int k = 2;

        int[] nums = {1, 2};
        int k = 3;
        Day2_RotateArray d2 = new Day2_RotateArray();
        d2.rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
