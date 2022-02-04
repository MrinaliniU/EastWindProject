package LeetCode.Algorithms.Medium;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        result.append(root.val).append(",");
        while (!nodeQueue.isEmpty()){
            TreeNode t = nodeQueue.poll();
            if(t.left != null){
                nodeQueue.add(t.left);
                result.append(t.left.val).append(",");
            }else result.append("null").append(",");
            if(t.right != null){
                nodeQueue.add(t.right);
                result.append(t.right.val).append(",");
            }else result.append("null").append(",");
        }

        return result.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        return root;
    }
    public static void main(String[] args){
        SerializeAndDeserializeBinaryTree sd = new SerializeAndDeserializeBinaryTree();
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
        String serialize = sd.serialize(root);
        System.out.println(serialize);
        sd.deserialize(serialize);
    }
}
