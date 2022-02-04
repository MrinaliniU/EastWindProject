package LeetCode.Algorithms.Hard;

public class MedianOfTwoSortedArray {

    /*
        Runtime: 2 ms, faster than 99.80%
        Memory Usage: 40.5 MB, less than 100.00%
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int median = nums.length / 2;
        int i = 0, j = 0, k = 0;
        while(i != nums1.length && j != nums2.length){
            if(nums1[i] <= nums2[j]) nums[k++] = nums1[i++];
            else nums[k++] = nums2[j++];

        }
        while(i != nums1.length) nums[k++] = nums1[i++];
        while(j != nums2.length) nums[k++] = nums2[j++];
        if(nums.length % 2 != 0) return nums[median];
        double a = nums[median], b = nums[median - 1];
        return (a + b) / 2;
    }

    public static void main(String[] args){
        MedianOfTwoSortedArray mt = new MedianOfTwoSortedArray();
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.print(mt.findMedianSortedArrays2(nums1, nums2));
    }
}
