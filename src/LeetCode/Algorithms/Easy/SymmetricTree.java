package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Problem No. 101.
 */
public class SymmetricTree {

    /*
        Space and time complexity both are O(n) but since we add root twice,
        the nodes stored are twice the number of nodes in the tree.
     */
    public boolean isSymmetricIterative(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 37.8 MB, less than 72.11%
       */
    public boolean isSymmetricRecursive(TreeNode root){
        return recursiveHelper(root, root);
    }

    private boolean recursiveHelper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return  recursiveHelper(node1.left, node2.right) && recursiveHelper(node1.right, node2.left);
    }
    public static void main(String[] args){
        SymmetricTree st = new SymmetricTree();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.left = new TreeNode(4);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.right = new TreeNode(3);
        root3.right.right = new TreeNode(3);
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricIterative(root1));
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricIterative(root2));
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricIterative(root3));
        System.out.println("--- Recursive Method ---");
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricRecursive(root1));
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricRecursive(root2));
        System.out.println("Tree1 is a Symmetric - " + st.isSymmetricRecursive(root3));

    }
}
