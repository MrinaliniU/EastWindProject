package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

public class BinaryTreePruning {
/*
    Runtime: 0 ms, faster than 100.00%
    Memory Usage: 37 MB, less than 5.88%
 */
    public TreeNode pruneTree(TreeNode root) {
         hasOne(root);
         return root;
    }

    public boolean hasOne(TreeNode node){
        if(node == null) return false;
        boolean L = hasOne(node.left);
        boolean R = hasOne(node.right);
        if(!L) node.left = null; // has no one prune
        if(!R) node.right = null; // has no one prune
        return L || R || node.val == 1;
    }

    public static void main(String[] args){
        BinaryTreePruning bp = new BinaryTreePruning();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);
        TreeNode root = bp.pruneTree(node);
    }
}
