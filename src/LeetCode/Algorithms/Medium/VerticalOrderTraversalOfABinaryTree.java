package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.*;
/* Need more work to pass all test cases in leetcode*/
public class VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root){
        if(root == null) return null;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        nodeQueue.add(root);
        levelQueue.add(0);
        ArrayList<Integer> t = new ArrayList<>();
        t.add(root.val);
        map.put(0, t);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer level = levelQueue.poll();
            if(node.left != null && level != null){
                nodeQueue.add(node.left);
                levelQueue.add(level - 1);
                t = map.getOrDefault(level - 1, new ArrayList<>());
                t.add(node.left.val);
                map.put(level - 1, t);
            }
            if(node.right != null && level != null){
                nodeQueue.add(node.right);
                levelQueue.add(level + 1);
                t = map.getOrDefault(level + 1, new ArrayList<>());
                t.add(node.right.val);
                map.put(level + 1, t);
            }
        }
        for(ArrayList<Integer> a : map.values()){
            Collections.sort(a);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args){
        VerticalOrderTraversalOfABinaryTree vb = new VerticalOrderTraversalOfABinaryTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(6);
        root.left.left.left.right.left = new TreeNode(10);
        root.left.left.left.right.right = new TreeNode(8);
        root.left.left.right.left.left = new TreeNode(11);
        root.left.left.right.left.right = new TreeNode(9);
        List<List<Integer>> result = vb.verticalTraversal(root);
        for(List<Integer> t : result){
            System.out.println(t);
        }
    }
}
