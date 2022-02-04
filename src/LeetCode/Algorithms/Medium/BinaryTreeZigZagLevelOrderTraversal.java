package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {
    /*
        Runtime: 1 ms, faster than 72.50%
        Memory Usage: 38.3 MB, less than 5.77%
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if (root == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        int prevLevel = 1;
        queue.add(root);
        level.add(1);
        result.add(Arrays.asList(root.val));
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            int currentLevel = level.poll();
            if(currentLevel != prevLevel){
                if(currentLevel % 2 == 0) Collections.reverse(temp);
                result.add(temp);
                temp = new ArrayList<>();
            }
            if(t.left != null){
                queue.add(t.left);
                level.add(currentLevel + 1);
                temp.add(t.left.val);
            }
            if(t.right != null){
                queue.add(t.right);
                level.add(currentLevel + 1);
                temp.add(t.right.val);
            }
            prevLevel = currentLevel;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.left.left = new TreeNode(10);
        t.left.right = new TreeNode(6);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        BinaryTreeZigZagLevelOrderTraversal bz = new BinaryTreeZigZagLevelOrderTraversal();
        List<List<Integer>> result = bz.zigzagLevelOrder(t);
        for(List<Integer> l : result){
            System.out.println(l);
        }

    }
}
