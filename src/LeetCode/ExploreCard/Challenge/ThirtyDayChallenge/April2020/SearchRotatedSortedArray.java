package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

/*
    Runtime: 0 ms, faster than 100.00%
    Memory Usage: 38.4 MB, less than 44.65%
 */
public class SearchRotatedSortedArray {
    /* we will do slightly modified version of Binary search */
    /* Create start and end pointer */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            // if left half is sorted
            if(nums[left] <= nums[mid]){
                // target falls in sorted range
                if(target >= nums[left] && target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // if right half is sorted
            else{
                // target falls in sorted range
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchRotatedSortedArray sa = new SearchRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(sa.search(nums, target));
    }
}
