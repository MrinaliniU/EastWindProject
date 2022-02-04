package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import Notes.DataStructures.TreeNode;
/*
    Runtime: 0 ms
    Memory Usage: 37.3 MB
 */
public class ConstructBinarySearchTreePreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            dfs_helper(root, preorder[i]);
        }
        return root;
    }
    public void dfs_helper(TreeNode node, int val){
        if (node == null) return;
        if(val < node.val){
            if(node.left == null) node.left = new TreeNode(val);
            else dfs_helper(node.left, val);
        }else{
            if(node.right == null) node.right = new TreeNode(val);
            else dfs_helper(node.right, val);
        }
    }
    public void pre_order(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        pre_order(root.left);
        pre_order(root.right);
    }
    public void in_order(TreeNode root){
        if(root == null) return;
        in_order(root.left);
        System.out.print(root.val + " ");
        in_order(root.right);
    }
    public static void main(String[] args){
        ConstructBinarySearchTreePreorderTraversal c = new ConstructBinarySearchTreePreorderTraversal();
        int[] pre_order = {8, 5, 1, 7, 10, 12};
        TreeNode root = c.bstFromPreorder(pre_order);
        c.pre_order(root);
        System.out.println();
        c.in_order(root);
    }
}
