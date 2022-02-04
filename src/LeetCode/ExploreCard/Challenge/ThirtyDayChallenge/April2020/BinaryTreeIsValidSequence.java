package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import Notes.DataStructures.TreeNode;
/*
    Runtime: 0 ms
    Memory Usage: 39.9 MB
 */
public class BinaryTreeIsValidSequence {
    int[] arr;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        this.arr = arr;
        return helper_dfs(root, 0);
    }
    public boolean helper_dfs(TreeNode node, int index){
        if(node == null) return false;
        if(isLeafNode(node)) return (index == arr.length - 1 && node.val == arr[index]);
        if(index >= arr.length || node.val != arr[index]) return false;
        return helper_dfs(node.left, index + 1) || helper_dfs(node.right, index + 1);
    }
    public boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static void main(String[] args){
        BinaryTreeIsValidSequence bv = new BinaryTreeIsValidSequence();
        /*TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(4);*/
        //int[] arr = {8};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(9);
        root.left.left.right.right = new TreeNode(3);
        int[] arr = {3, 0};
        System.out.println(bv.isValidSequence(root, arr));
    }
}
