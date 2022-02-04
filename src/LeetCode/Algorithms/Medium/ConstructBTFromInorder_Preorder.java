package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.HashMap;

public class ConstructBTFromInorder_Preorder {
    /*
        Runtime: 2 ms, faster than 71.72%
        Memory Usage: 39.3 MB, less than 15.89%
     */
    int[] preorder;
    int[] inorder;
    int preorder_index;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preorder_index = 0;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(0, inorder.length - 1);
    }
    public TreeNode helper(int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preorder_index]);
        int index = map.get(root.val);
        preorder_index++;
        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);
        return root;
    }
    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    public static void main(String[] args){
        ConstructBTFromInorder_Preorder c = new ConstructBTFromInorder_Preorder();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = c.buildTree(preorder, inorder);
        c.inorder(node);
    }
}
