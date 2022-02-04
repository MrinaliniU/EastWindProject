package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    /*
        BFS
        Runtime: 2 ms, faster than 85.04%
        Memory Usage: 39.9 MB, less than 5.55%
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        queue.add(root);
        depth.add(0);
        int min = 0, max = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer level = depth.poll();

            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(node.val);
            min = Math.min(min, level);
            max = Math.max(max, level);
            if(node.left != null) {
                queue.add(node.left);
                depth.add(level - 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                depth.add(level + 1);
            }
        }
        for(int i = min; i <= max; i++){
            result.add(new ArrayList<>(map.get(i)));
        }
        return result;
    }
    public static void main(String[] args){
        BinaryTreeVerticalOrderTraversal bt = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(5);
        for(List<Integer> i : bt.verticalOrder(root)) System.out.println(i);
    }
}
