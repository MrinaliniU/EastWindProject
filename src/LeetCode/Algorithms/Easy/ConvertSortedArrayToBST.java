package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;
/*
    Runtime: 0 ms, faster than 100.00%
 */
public class ConvertSortedArrayToBST {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    public TreeNode helper(int left, int right){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }
}
