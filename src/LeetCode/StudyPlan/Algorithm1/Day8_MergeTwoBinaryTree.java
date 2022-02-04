package LeetCode.StudyPlan.Algorithm1;

import Notes.DataStructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Day8_MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1 == null || n2 == null) continue;
            q1.add(n1.left);
            q1.add(n1.right);
            q2.add(n2.left);
            q2.add(n2.right);
            if (n1 != null && n2 != null) {
                n1.val = n1.val + n2.val;
            }
            if (n1.left == null) n1.left = n2.left;
            if (n1.right == null) n1.right = n2.right;
        }
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        Day8_MergeTwoBinaryTree d8 = new Day8_MergeTwoBinaryTree();
        d8.mergeTrees(root1, root2);
    }
}
