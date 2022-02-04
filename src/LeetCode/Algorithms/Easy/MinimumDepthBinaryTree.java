package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39 MB, less than 98.44%
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size != 0){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return level;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size--;
            }
            level++;
        }
        return -1;
    }
}
