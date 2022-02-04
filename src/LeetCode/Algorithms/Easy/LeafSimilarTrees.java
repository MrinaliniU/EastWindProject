package LeetCode.Algorithms.Easy;

import Notes.Trees.BinaryTree.CompleteBinaryTree;
import Notes.DataStructures.TreeNode;
import java.util.ArrayList;

/*
    Problem No: 872.
    Consider all leaf nodes of two tree from left to right order.
    Return true if both trees have same leaf nodes in same order, else return false.
 */

public class LeafSimilarTrees {

    ArrayList<Integer> leavesOfTree1 = new ArrayList<>();
    ArrayList<Integer> leavesOfTree2 = new ArrayList<>();

    public boolean isLeafSimilar(TreeNode root1, TreeNode root2){
        findLeaves(root1, leavesOfTree1);
        findLeaves(root2, leavesOfTree2);
        return leavesOfTree1.equals(leavesOfTree2);
    }

    public void findLeaves(TreeNode treeNode, ArrayList<Integer> list){
        if(treeNode == null)
            return;
        if(isLeafNode(treeNode))
            list.add(treeNode.val);
        findLeaves(treeNode.left, list);
        findLeaves(treeNode.right, list);
    }

    public boolean isLeafNode(TreeNode treeNode){
        return (treeNode.left == null && treeNode.right == null);
    }
    public static void main(String[] args){
        CompleteBinaryTree tree1 = new CompleteBinaryTree();
        CompleteBinaryTree tree2 = new CompleteBinaryTree();
        LeafSimilarTrees ls = new LeafSimilarTrees();
        tree1.insert(3);
        tree1.insert(5);
        tree1.insert(1);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(2);
        if(ls.isLeafSimilar(tree1.root, tree2.root)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
