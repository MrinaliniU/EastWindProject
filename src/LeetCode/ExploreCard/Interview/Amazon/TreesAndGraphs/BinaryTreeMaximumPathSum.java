package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import Notes.DataStructures.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    /* Notice how this is similar to the diameter of a binary tree
    * there you add + 1 instead of + node.value because there you are counting number of edges and depth
    * here you are calculating sum.
    * The limit for R and L is required here because if either R or L gives a -ve value you don't want
    * want to add it to your max path because adding a -ve value never increasing the sum so you limit it with 0.
    * */
    /*
        Runtime: 0 ms
        Memory Usage: 41.1 MB
     */
    public int helper(TreeNode node){
        if(node == null) return 0;
        int L = Math.max(helper(node.left), 0);
        int R = Math.max(helper(node.right), 0);
        max = Math.max(max, L + R + node.val);
        return Math.max(L , R) + node.val;
    }

    public static void main(String[] args){
        BinaryTreeMaximumPathSum path = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Max Path Sum " + path.maxPathSum(root));
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(-1);
        System.out.println("Max Path Sum " + path.maxPathSum(root2));
    }
}
