package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeInOrderTraversal {

    public void inOrderIterative(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            // root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-5);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        IterativeInOrderTraversal t = new IterativeInOrderTraversal();
        t.inOrderIterative(root);
    }
}
