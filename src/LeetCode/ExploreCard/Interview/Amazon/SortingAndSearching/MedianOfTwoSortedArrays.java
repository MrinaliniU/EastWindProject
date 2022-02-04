package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int median_index = len / 2;
        int nums1_pointer = 0, nums2_pointer = 0, median_pointer = 0;
        int[] median = new int[len];
        while(nums1_pointer < nums1.length && nums2_pointer < nums2.length){
            if(nums1[nums1_pointer] <= nums2[nums2_pointer])
                median[median_pointer++] = nums1[nums1_pointer++];
            else median[median_pointer++] = nums2[nums2_pointer++];
            if(median_pointer == median_index) break;
        }
        if(len % 2 == 0) return (median[median_pointer - 1] + median[median_pointer - 2]) / 2;
        else return median[median_pointer];

    }
    public static void main(String[] args){
        MedianOfTwoSortedArrays ms = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3}; int[] nums2 = {3, 4};
        System.out.print(ms.findMedianSortedArrays(nums1, nums2));
    }
}
