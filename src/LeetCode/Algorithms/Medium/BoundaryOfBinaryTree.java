package LeetCode.Algorithms.Medium;
import Notes.DataStructures.TreeNode;

import java.util.*;
public class BoundaryOfBinaryTree {
    List<Integer> solution;
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39.9 MB, less than 21.05%
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        solution = new ArrayList<>();
        if(root == null) return solution;
        solution.add(root.val);
        boundaryLeft(root.left);
        leaves(root.left);
        leaves(root.right);
        boundaryRight(root.right);
        return solution;
    }

    /* In order template */
    public void leaves(TreeNode node){
        if(node == null) return;
        leaves(node.left);
        if(node.left == null && node.right == null)
            solution.add(node.val);
        leaves(node.right);
    }

    public void boundaryLeft(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            solution.add(node.val); // top down print
            boundaryLeft(node.left);
        }else if(node.right != null){
            solution.add(node.val); // top down print
            boundaryLeft(node.right);
        }
        // if both left and right are null then it's leaf node don't print
    }

    public void boundaryRight(TreeNode node){
        if(node == null) return;
        if(node.right != null){
            boundaryRight(node.right);
            solution.add(node.val);
        }else if(node.left != null){
            boundaryRight(node.left);
            solution.add(node.val);
        }
    }

    public static void main(String[] args) {
        BoundaryOfBinaryTree bt = new BoundaryOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        /* -------------------------------------------- */
        TreeNode root1 = new TreeNode(200);
        root1.left = new TreeNode(150);
        root1.right = new TreeNode(206);
        root1.left.left = new TreeNode(100);
        root1.right.right = new TreeNode(210);
        root1.left.left.left = new TreeNode(90);
        root1.left.left.right = new TreeNode(125);
        root1.left.left.right.right = new TreeNode(135);
        root1.left.left.right.right.left = new TreeNode(130);
        root1.left.left.right.right.right = new TreeNode(140);
        List<Integer> result = bt.boundaryOfBinaryTree(root);
        System.out.println(result);
    }
}
