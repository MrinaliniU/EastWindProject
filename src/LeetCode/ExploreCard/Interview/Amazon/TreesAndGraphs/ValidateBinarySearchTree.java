package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import Notes.DataStructures.TreeNode;

public class ValidateBinarySearchTree {
    /*
        In Order Traversal.
        Runtime: 2 ms
        Memory Usage: 41.8 MB
     */
    Integer stack = null;
    public boolean isValidBST(TreeNode root){
        return inOrder(root);
    }
    public boolean inOrder(TreeNode node){
        if(node == null) return true;
        boolean l = inOrder(node.left);
        boolean p = stack == null || stack < node.val;
        stack = node.val;
        boolean r = inOrder(node.right);
        return l && p && r;
    }
    public boolean _isValidBST(TreeNode root) {
        return preOrder(root, null, null);
    }
    /*Time and space O(N)
    Runtime: 0 ms, faster than 100.00%
    Memory Usage: 39.4 MB, less than 80.47%
    * */
    public boolean preOrder(TreeNode node, Integer low, Integer high){
        if(node == null) return true;
        int val = node.val;
        /* check if current node val falls within the range */
        if(low != null && val <= low || high != null && val >= high) return false;
        /* check both left and right tree are valid BST */
        return preOrder(node.left, low, val) && preOrder(node.right, val, high);
    }
    /* In order to understand above code I've written it so but the above code is faster and uses less
    * memory */
    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null) return true;
        int val = node.val;
        boolean P = (low == null || val > low) && (high == null || val < high);
        boolean L = helper(node.left, low, val);
        boolean R = helper(node.right, val, high);
        return P && L && R;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(10);
        ValidateBinarySearchTree vb = new ValidateBinarySearchTree();
        System.out.println("Is a binary search tree " + vb.isValidBST(root));
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is a binary search tree " + vb.isValidBST(root2));
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println("Is a binary search tree " + vb.isValidBST(root3));

    }
}
