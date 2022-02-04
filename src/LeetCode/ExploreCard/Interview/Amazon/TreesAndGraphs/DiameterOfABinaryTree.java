package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import Notes.DataStructures.TreeNode;
/*
    Runtime: 0 ms
    Memory Usage: 39 MB
 */
public class DiameterOfABinaryTree {
    int ans;
    public int diameter(TreeNode root){
        ans = 0;
        depth(root);
        return ans;
    }
    public int depth(TreeNode node){
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }
}
