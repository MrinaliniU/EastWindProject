package LeetCode.Algorithms.Easy;

import Notes.DataStructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

    /*
        Divide and Conquer. O(n log n).
     */
    public int pathSum(TreeNode root, int givenSum){
        if(root == null) return 0;
        return helper(root, givenSum) + pathSum(root.left, givenSum) + pathSum(root.right, givenSum);
    }

    private int helper(TreeNode node, int sum){
        int count = 0;
        if(node == null) return count;
        if(node.val == sum) count += 1;
        count += helper(node.left, sum - node.val);
        count += helper(node.right, sum - node.val);
        return count;
    }

    /*
        Backtracking method. Both space and time complexity O(n).
        Why is complexity O(n) ?.
        Runtime: 2 ms, faster than 100.00%
        Memory Usage: 41.1 MB, less than 56.82%
    */
    public int pathSumBackTracking(TreeNode root, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int calculatedSum = 0;
        map.put(0, 1);
        return backTrackHelper(root, k, calculatedSum, map);
    }

    private int backTrackHelper(TreeNode node, int k, int calculatedSum, Map<Integer, Integer> map){
        if(node == null) return 0;
        calculatedSum += node.val;
        int count = map.getOrDefault(calculatedSum - k, 0); //This line must be before ---
        map.put(calculatedSum, map.getOrDefault(calculatedSum, 0) + 1);/*--- this line, because the solution
                                                                                      for Tree = [1], sum = 0.
                                                                                      */
        count = count + backTrackHelper(node.left, k, calculatedSum, map) +
                backTrackHelper(node.right, k, calculatedSum, map);
        map.put(calculatedSum, map.get(calculatedSum) - 1); // So that left tree map does not affect right tree map.
        return count;
    }

    public static void main(String[] args){
        PathSum3 p3 = new PathSum3();
        TreeNode root1 = new TreeNode(1);
        int givenSum1 = 0;
        System.out.println("The number of paths to " + givenSum1 + " is " + p3.pathSum(root1, givenSum1));
        System.out.println("The number of paths to " + givenSum1 + " is " + p3.pathSumBackTracking(root1, givenSum1));
        int givenSum2 = 3;
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(3);

        System.out.println("The number of paths to " + givenSum2 + " is " + p3.pathSum(root2, givenSum2));
        System.out.println("The number of paths to " + givenSum2 + " is " + p3.pathSumBackTracking(root2, givenSum2));

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(8);
        root3.left.left = new TreeNode(11);
        root3.left.left.left = new TreeNode(7);
        root3.left.left.right = new TreeNode(2);
        root3.right.left = new TreeNode(13);
        root3.right.right = new TreeNode(4);
        root3.right.right.left = new TreeNode(5);
        root3.right.right.right = new TreeNode(1);
        int givenSum3 = 22;
        System.out.println("The number of paths to " + givenSum3 + " is " + p3.pathSum(root3, givenSum3));
        System.out.println("The number of paths to " + givenSum3 + " is " + p3.pathSumBackTracking(root3, givenSum3));

        TreeNode root4 = new TreeNode(5);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(8);
        int givenSum = 9;
        System.out.println("The number of paths to " + givenSum + " is " + p3.pathSum(root4, givenSum));
        System.out.println("The number of paths to " + givenSum + " is " + p3.pathSumBackTracking(root4, givenSum));
    }
}
