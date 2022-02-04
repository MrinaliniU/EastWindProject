package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import Notes.DataStructures.TreeNode;

public class DiameterOfBinaryTree {
    /*
        While measuring the diameter we count the number of edges between two nodes.
        number of nodes in left + number of nodes in right
        While measuring the depth we select the maximum of the number of nodes in left and right
        node of a root + 1.
     */
    int ans = 0;
    /*
        Runtime: 0 ms
        Memory Usage: 39.7 MB
     */
    public int diameterOfABinaryTree(TreeNode node){
        depth(node);
        return ans;
    }
    public int depth(TreeNode node){
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }
    public static void main(String[] args){
        DiameterOfBinaryTree dobt = new DiameterOfBinaryTree();
        TreeNode bt = new TreeNode(1);
        bt.left = new TreeNode(2);
        bt.left.left = new TreeNode(4);
        bt.left.left.left = new TreeNode(5);
        bt.left.left.left.left = new TreeNode(6);
        bt.left.left.left.left.left = new TreeNode(7);
        bt.left.left.left.left.left.left = new TreeNode(8);
        bt.left.left.left.left.left.left.left = new TreeNode(9);
        bt.left.left.left.right = new TreeNode(14);
        bt.left.left.left.right.right = new TreeNode(13);
        bt.left.left.left.right.right.right = new TreeNode(12);
        bt.left.left.left.right.right.right.right = new TreeNode(11);
        bt.right = new TreeNode(1);
        bt.right.right = new TreeNode(2);
        bt.right.right.right = new TreeNode(3);
        System.out.println("The diameter is " + dobt.diameterOfABinaryTree(bt));
    }
}
