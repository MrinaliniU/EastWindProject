package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;

import java.util.*;
/*
    Runtime: 1 ms, faster than 81.25%
    Memory Usage: 39.3 MB, less than 5.00%
    */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            result.add(0, new ArrayList<>());
            while(queueSize != 0){
                TreeNode node = queue.poll();
                result.get(0).add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                queueSize--;
            }
        }
        return result;
    }
}
