package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.*;
public class BinaryTreeRightSideView {
    /*
        Runtime: 1 ms, faster than 77.21%
        Memory Usage: 38.1 MB, less than 5.88%
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int _s = size;
            while (size != 0){
                TreeNode node = queue.poll();
                if(_s == size) result.add(node.val);
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
                size--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        BinaryTreeRightSideView r = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(r.rightSideView(root));
    }
}
