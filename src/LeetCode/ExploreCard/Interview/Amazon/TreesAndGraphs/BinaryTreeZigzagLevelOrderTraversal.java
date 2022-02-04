package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
import Notes.DataStructures.TreeNode;

import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 38.1 MB, less than 5.77%
     */
    List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode node, int level){
        if(node == null) return;
        if(result.size() == level) result.add(new ArrayList<>());
        if(level % 2 == 0) result.get(level).add(node.val);
        if(level % 2 != 0) result.get(level).add(0, node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args){
        BinaryTreeZigzagLevelOrderTraversal bz = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode bst = new TreeNode(200);
        bst.left = new TreeNode(150);
        bst.right = new TreeNode(206);
        bst.left.left = new TreeNode(100);
        bst.right.right = new TreeNode(210);
        bst.left.left.left = new TreeNode(90);
        bst.left.left.right = new TreeNode(125);
        bst.left.left.right.right = new TreeNode(135);
        bst.left.left.right.right.left = new TreeNode(130);
        bst.left.left.right.right.right = new TreeNode(140);
        List<List<Integer>> result = bz.zigzagLevelOrder(bst);
        for(List<Integer> r : result) System.out.println(r);
    }
}
