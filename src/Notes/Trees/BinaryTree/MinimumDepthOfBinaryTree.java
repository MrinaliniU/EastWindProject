package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    /* BFS Method to catch the first leaf node from left to right */
    public int minimumDepth(TreeNode root){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        /* Using helper queue to store depth of each node */
        Queue<Integer> depthQueue = new LinkedList<>();
        int depth = 1;
        nodeQueue.add(root);
        depthQueue.add(depth);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            assert depthQueue.peek() != null;
            depth = depthQueue.poll();
            if(node.left == null && node.right == null){
                return depth;
            }
            if(node.left != null){
                nodeQueue.add(node.left);
                depthQueue.add(depth + 1);
            }
            if(node.right != null){
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
            }
        }
        return depth;
    }
    /* Recursive method like DFS*/
    public int maximumDepth(TreeNode root, int depth){
        if(root == null)
            return depth;
       return Math.max(maximumDepth(root.left, depth + 1), maximumDepth(root.right, depth + 1));
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(5);
        tree.left.left.left = new TreeNode(4);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(16);
        tree.right.right = new TreeNode(15);
        tree.right.right.left = new TreeNode(25);
        tree.right.right.left.right = new TreeNode(6);
        MinimumDepthOfBinaryTree md = new MinimumDepthOfBinaryTree();
        System.out.println(md.maximumDepth(tree, 0));
        System.out.println(md.minimumDepth(tree));
    }
}
