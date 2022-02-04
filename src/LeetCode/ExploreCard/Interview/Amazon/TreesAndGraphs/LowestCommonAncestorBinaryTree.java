package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import Notes.DataStructures.TreeNode;

public class LowestCommonAncestorBinaryTree {
    /*
        Runtime: 4 ms
        Memory Usage: 41.7 MB
     */
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        boolean L = dfs(node.left, p, q);
        boolean R = dfs(node.right, p, q);
        boolean P = node.equals(p) || node.equals(q);
        if(L && R || P) result = node;
        return L || R || P;
    }
    public static void main(String[] args){
        LowestCommonAncestorBinaryTree lc = new LowestCommonAncestorBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(lc.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
