package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){ // had to be less than equal to
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            // if left is sorted
            if(nums[mid] >= nums[left]){ // has to be greater than equal to
                // does the target fall within the sorted range?
                if(target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            else{
                // does the target fall within the sorted range?
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        SearchRotatedSortedArray sa = new SearchRotatedSortedArray();
        //int[] nums = {4, 5, 6, 7, 0, 1, 2}; int target = 3;
        // int[] nums = {5, 1, 3}; int target = 3;
        int[] nums = {3, 1}; int target = 1;
        System.out.print(sa.search(nums, target));
    }
}
