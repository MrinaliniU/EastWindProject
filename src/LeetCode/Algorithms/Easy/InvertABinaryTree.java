package LeetCode.Algorithms.Easy;

import Notes.Trees.BinaryTree.DepthFirstSearch;
import Notes.DataStructures.TreeNode;

public class InvertABinaryTree {

    public TreeNode invertTree(TreeNode root){
        helper(root);
        return root;
    }

    private void helper(TreeNode treeNode){
        if(isLeafNode(treeNode) || treeNode == null)
            return;
        if(treeNode.left == null){
            treeNode.left = treeNode.right;
            treeNode.right = null;
        }else if(treeNode.right == null){
            treeNode.right = treeNode.left;
            treeNode.left = null;
        }else{
            TreeNode temp = treeNode.right;
            treeNode.right = treeNode.left;
            treeNode.left = temp;
        }
        helper(treeNode.left);
        helper(treeNode.right);
    }
    private boolean isLeafNode(TreeNode treeNode){
        if(treeNode == null)
            return false;
        return (treeNode.left == null && treeNode.right == null);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        DepthFirstSearch ds = new DepthFirstSearch();
        ds.inOrder(root);
        System.out.println();
        InvertABinaryTree iv = new InvertABinaryTree();
        iv.invertTree(root);
        ds.inOrder(root);
    }
}
