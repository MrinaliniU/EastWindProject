package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;
import java.util.*;

public class SubTreeOfAnotherTree {
    /*
        Much Better Performance
        Runtime: 8 ms, faster than 15.15%
        Memory Usage: 40 MB, less than 97.78%
     */

    public boolean isSubtree(TreeNode s, TreeNode t){
        String s1 = getPreOrderString(s);
        String t1 = getPreOrderString(t);
        return s1.contains(t1);
    }
    public String getPreOrderString(TreeNode t){
        StringBuilder s = new StringBuilder();
        preOrder(t, s);
        return s.toString();
    }
    public void preOrder(TreeNode t, StringBuilder s){
        if(t == null) return;
        s.append("#").append(t.val).append(" ");
        // i don't see why lnull rnull is required, all tests passed without it
        if(t.left != null) preOrder(t.left, s); else s.append("null "); // leetcode solution said append lnull
        if(t.right != null) preOrder(t.right, s); else s.append("null "); // leetcode solution said append rnull
    }

    /*
        Horrible performance and memory used
        Runtime: 114 ms, faster than 5.68%
        Memory Usage: 99.9 MB, less than 6.67%
     */
    public boolean isSubTree(TreeNode s, TreeNode t){
        if((s == null && t == null) || (s != null && t == null)) return true;
        if(s == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            TreeNode T = queue.poll();
            if(sameTree(T, t)) return true;
            if(T.left != null) queue.add(T.left);
            if(T.right != null) queue.add(T.right);
        }
        return false;
    }

    public boolean sameTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        q1.add(t1);
        q2.add(t2);
        while (!q1.isEmpty()){
            TreeNode T1 = q1.poll();
            if(T1 != null) a1.add(T1.val);
            if(T1.left != null) q1.add(T1.left);
            if(T1.right != null) q1.add(T1.right);

        }
        while(!q2.isEmpty()){
            TreeNode T2 = q2.poll();
            if(T2 != null) a2.add(T2.val);
            if(T2.left != null) q2.add(T2.left);
            if(T2.right != null) q2.add(T2.right);
        }
        return a1.equals(a2);
    }

    public static void main(String[] args){
        SubTreeOfAnotherTree st = new SubTreeOfAnotherTree();
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        System.out.println("--- level traversal method----");
        if(st.isSubTree(s, t)) System.out.println("t is subtree of s");
        else System.out.println("t is not subtree of s");
        System.out.println("--- pre order method----");
        if(st.isSubtree(s, t)) System.out.println("t is subtree of s");
        else System.out.println("t is not subtree of s");
    }
}
