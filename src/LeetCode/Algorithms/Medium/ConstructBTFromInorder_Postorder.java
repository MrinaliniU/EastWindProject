package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.*;

public class ConstructBTFromInorder_Postorder {
    int postOrder_index;
    int[] inorder, postorder;
    HashMap<Integer, Integer> inorder_map;
    /*
        Runtime: 2 ms, faster than 67.27%
        Memory Usage: 39.4 MB, less than 21.82%
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorder_map = new HashMap<>();
        postOrder_index = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++) inorder_map.put(inorder[i], i);
        return helper(0, inorder.length - 1);
    }
    public TreeNode helper(int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(postorder[postOrder_index]);// parent
        postOrder_index--;
        int index = inorder_map.get(root.val);
        root.right = helper(index + 1, right);// right
        root.left = helper(left, index - 1);// left
        return root;
    }

    public static void main(String[] args){

    }
}
