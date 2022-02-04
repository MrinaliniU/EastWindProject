package LeetCode.Algorithms.Easy;
import Notes.DataStructures.TreeNode;
import java.util.*;
/*
    Problem Number: 501.
 */

public class ModeInBinarySearchTree {
    Integer prev = null;
    int count = 1;
    int max = 0;
    /* Runtime: 0 ms, faster than 100.00%
    * Memory Usage: 42 MB, less than 7.14% */
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) result[i] = list.get(i);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list); // in order traversal
        // prev has to be Integer and not int because node value itself can be 0;
        if (prev != null) count = node.val == prev ? count + 1 : 1;

        if (count > max) {
            max = count;
            list.clear();
            list.add(node.val);
        }
        else if (count == max) list.add(node.val); // this is so that there could be more than one mode
        prev = node.val;
        traverse(node.right, list);  // in order traversal
    }

    public static void main(String[] args){
        ModeInBinarySearchTree m = new ModeInBinarySearchTree();
        TreeNode t = new TreeNode(0);
        t.right = new TreeNode(0);
        int[] result = m.findMode(t);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
