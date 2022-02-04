package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;

/* Problem no. 104 */

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root){
        return helper(root, 0);
    }
    private int helper(TreeNode treeNode, int count){
        if(treeNode == null)
            return count;
        count = Math.max(helper(treeNode.left, count), helper(treeNode.right, count)) + 1;
        return count;
    }

    public static void main(String[] args){
        MaximumDepthOfBinaryTree md = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("The max depth of given tree is: " + md.maxDepth(root));
    }
}
