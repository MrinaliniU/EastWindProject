package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

public class InorderSuccessorBST {
    /*
        Runtime: 1 ms, faster than 100.00%
        Memory Usage: 40.4 MB, less than 5.26%
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode candidate = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                candidate = cur;
                cur = cur.left;
            }
            else cur = cur.right;
        }
        return candidate;
    }

    public static void main(String[] args){
        InorderSuccessorBST ibst = new InorderSuccessorBST();
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(11);
    }
}
