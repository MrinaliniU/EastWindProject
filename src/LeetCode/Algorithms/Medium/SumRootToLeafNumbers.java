package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

public class SumRootToLeafNumbers {
    int answer;
    public int sumNumbers(TreeNode root) {
        this.answer = 0;
        traverse(root, 0);
        return this.answer;
    }

    private void traverse(TreeNode n, int parentVal) {
        if (n == null) return;
        if (n.left == null && n.right == null) {
            this.answer += (parentVal * 10) + n.val;
            return;
        }
        parentVal = (parentVal * 10) + n.val;
        traverse(n.left, parentVal);
        traverse(n.right, parentVal);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sm = new SumRootToLeafNumbers();
        TreeNode n = new TreeNode(0);
        n.left = new TreeNode(9);
        n.left.left = new TreeNode(5);
        n.left.right = new TreeNode(1);
        n.right = new TreeNode(0);
        int ans = sm.sumNumbers(n);
        System.out.println(ans);
    }
}
