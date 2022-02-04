package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void breadthFirstSearch(TreeNode root){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            System.out.print(node.val + " ");
            if(node.left != null)
                nodeQueue.add(node.left);
            if(node.right != null)
                nodeQueue.add(node.right);
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(5);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.breadthFirstSearch(root);
    }
}
