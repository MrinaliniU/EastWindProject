package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*
    Complete Binary Tree.
    A Queue data-structure is used to create a complete binary tree.
    The insertion order at each level is from left to right.
    In this queue, the peek node indicates a leaf node that has space for a new child to be inserted.
    When the peek node gets both left and right child it is polled out of the queue.
 */

public class CompleteBinaryTree {
    public int value;
    public TreeNode root;
    Queue<TreeNode> treeNodeToInsert = new LinkedList<>();

    public void insert(int value){
        if(treeNodeToInsert.isEmpty()){ // Logic when root node needs to be created
            this.root = new TreeNode(value);
            treeNodeToInsert.add(this.root);
        }else{
            insert(value, Objects.requireNonNull(treeNodeToInsert.peek()));
        }
    }

    private void insert(int value, TreeNode treeNode){
        if(treeNode.left == null){
            treeNode.left = new TreeNode(value);
            treeNodeToInsert.add(treeNode.left);
        }else if(treeNode.right == null){
            treeNode.right = new TreeNode(value);
            treeNodeToInsert.add(treeNode.right);
        }else{
            treeNodeToInsert.poll();
            insert(value, Objects.requireNonNull(treeNodeToInsert.peek()));
        }
    }
}
