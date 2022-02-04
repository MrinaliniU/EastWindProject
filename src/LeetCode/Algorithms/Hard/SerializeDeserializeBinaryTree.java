package LeetCode.Algorithms.Hard;

import Notes.DataStructures.TreeNode;

import java.util.*;
/*
    Runtime: 8 ms, faster than 81.44%
    Memory Usage: 41.7 MB, less than 20.95%
 */
public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        sRecurse(root, s);
       return s.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return dRecurse(data_list);
    }
    public void sRecurse(TreeNode node, StringBuilder s){
        if(node == null){
            s.append("null,");
            return;
        }
        s.append(node.val).append(",");
        sRecurse(node.left, s);
        sRecurse(node.right, s);
    }
    public TreeNode dRecurse(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.remove(0)));
        root.left = dRecurse(list);
        root.right = dRecurse(list);
        return root;
    }
    public static void main(String[] args){
        SerializeDeserializeBinaryTree sb = new SerializeDeserializeBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        node.right.right.right = new TreeNode(6);
        sb.serialize(node);
        String serialize = sb.serialize(node);
        System.out.print(serialize);
        TreeNode node2 = sb.deserialize(serialize);
    }
}
