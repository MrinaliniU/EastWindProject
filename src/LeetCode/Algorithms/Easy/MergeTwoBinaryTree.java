package LeetCode.Algorithms.Easy;

import Notes.Trees.BinaryTree.DepthFirstSearch;
import Notes.DataStructures.TreeNode;

/*
    Problem no. 617.
 */
public class MergeTwoBinaryTree {

    /* Better solution. This just adds up Tree2 node values to Tree1 nodes.*/
    public TreeNode mergeTrees(TreeNode treeNode1, TreeNode treeNode2){
        if(treeNode1 == null)
            return treeNode2; // If a node in Tree1 is null it points to the node in tree 2;
        if(treeNode2 == null)
            return treeNode1;
        treeNode1.val += treeNode2.val;
        treeNode1.left = mergeTrees(treeNode1.left, treeNode2.left);
        treeNode1.right = mergeTrees(treeNode1.right, treeNode2.right);
        return treeNode1;
    }
    /* My solution. Creates a new Tree and new nodes with values that is sum of Tree1 nodes and Tree2 nodes */
    public TreeNode _mergeTrees(TreeNode treeNode1, TreeNode treeNode2){
        TreeNode newRoot = new TreeNode(treeNode1.val + treeNode2.val);
        mergeTrees(treeNode1, treeNode2, newRoot);
        return newRoot;
    }
    private void mergeTrees(TreeNode treeNode1, TreeNode treeNode2, TreeNode treeNode){
        if(treeNode == null)
            return;
        if(treeNode1 == null){
            treeNode.left = sumNode(null, treeNode2.left);
            treeNode.right = sumNode(null, treeNode2.right);
            mergeTrees(null, treeNode2.left, treeNode.left);
            mergeTrees(null, treeNode2.right, treeNode.right);
        }
        else if(treeNode2 == null){
            treeNode.left = sumNode(treeNode1.left, null);
            treeNode.right = sumNode(treeNode1.right, null);
            mergeTrees(treeNode1.left, null, treeNode.left);
            mergeTrees(treeNode1.right, null, treeNode.right);
        }else{
            treeNode.left = sumNode(treeNode1.left, treeNode2.left);
            treeNode.right = sumNode(treeNode1.right, treeNode2.right);
            mergeTrees(treeNode1.left, treeNode2.left, treeNode.left);
            mergeTrees(treeNode1.right, treeNode2.right, treeNode.right);
        }

    }
    private TreeNode sumNode(TreeNode treeNode1, TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null)
            return null;
        if(treeNode1 == null)
            return new TreeNode(treeNode2.val);
        if(treeNode2 == null)
            return new TreeNode(treeNode1.val);
        return new TreeNode(treeNode1.val + treeNode2.val);
    }
    public static void main(String[] args){
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree2.right = new TreeNode(2);
        tree2.right.right = new TreeNode(3);
        DepthFirstSearch dfs = new DepthFirstSearch();
        MergeTwoBinaryTree merge = new MergeTwoBinaryTree();
        TreeNode newTreeTreeNode = merge.mergeTrees(tree1, tree2);
        dfs.inOrder(newTreeTreeNode);
    }
}
