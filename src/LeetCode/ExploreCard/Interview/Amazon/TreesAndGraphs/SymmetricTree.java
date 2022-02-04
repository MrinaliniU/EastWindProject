package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import Notes.DataStructures.TreeNode;

import java.util.*;

public class SymmetricTree {
    /* Breadth first approach
       Runtime: 1 ms
       Memory Usage: 39.3 MB
       */
       /* The below code is easy to understand but can be simplified as follows.
       * 1. Basic Checks:
       *  - if both T1 and T2 are null continue;
       *  - if either T1 and T2 is null return false
       *  - if T1.val != T2.val return false.
       * 2. Add all left and right child irrespective of whether they are null or not
       *    - queue.add(T1.left);
       *    - queue.add(T2.right);
       *    - queue.add(T1.right);
       *    - queue.add(T2.left);
       * */
    public boolean isSymmetricBFS(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode T1 = queue.poll();
            TreeNode T2 = queue.poll();
            if(T1 == null && T2 == null) continue;
            if(T1 == null || T2 == null) return false;
            if(T1.val != T2.val) return false;
            queue.add(T1.left);
            queue.add(T2.right);
            queue.add(T1.right);
            queue.add(T2.left);
        }
        return true;
    }
    /*
        Runtime: 1 ms
        Memory Usage: 39.7 MB
     */
    public boolean isSymmetricDFS(TreeNode root){
       return helper(root, root);
    }
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
    public static void main(String[] args){
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(st.isSymmetricDFS(root));
    }
}
