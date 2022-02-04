package Notes.Trees.BinaryTree;

/*
    This algorithm is a variation of Vertical Traversal of a Binary Tree.
    Refer: BottomViewBinaryTree.png
    ## The top image shows all the nodes (marked in blue) that would be considered the bottom view nodes
        of the given binary tree. Note how at each vertical levels the bottom most node is the output.
    ## The bottom image is a scenario where more than two nodes (E and J) overlap and form the bottom most
        nodes of a vertical level. In such case the right most node that is J is considered in the out put.
        E is right child of B and J is left child of C
    - Vertical Traversal of a Binary tree is done assuming that each vertical level is at x - 1 or x + 1
    distance away from the middle vertical level which is the root column. So if root column is at 0 then
    the column left to it is -1 and the one right to it is +1.
    - Each node needs to it's vertical level saved. Can be done with DFS logic. If key is the vertical level
    for a node then it's left child has vertical level ke - 1 and right one has key + 1.
    - But for us to output just the bottom nodes it is important to traverse in level order. That is BFS.
    Adding the vertical level and node as a <key, node> pair into a map in a BFS traversal order would ensure
    that the last key, value added to the list is bottom most nodes.
    - Since DFS messes the order needed explained in previous point, we can keep track of the keys in another
    queue similar to the one used to store nodes for BFS traversal.
 */

import Notes.DataStructures.TreeNode;

import java.util.*;

public class BottomViewBinaryTree {
    HashMap<Integer, Integer> mapOfLevelAndNodes = new HashMap<>();
    /* This queue is for the BFS traversal of the tree */
    Queue<TreeNode> treeNodeQueue = new LinkedList<>();
    /* This level keeps track of the key of each node in the same queue-order of the tree */
    Queue<Integer> horizontalDistanceQueue = new LinkedList<>();

    public List<Integer> bottomViewNodes(TreeNode root){
        treeNodeQueue.add(root);
        horizontalDistanceQueue.add(0);
        while(!treeNodeQueue.isEmpty()){
            TreeNode node = treeNodeQueue.poll();
            Integer key = horizontalDistanceQueue.poll();
            if(node.left != null){
                treeNodeQueue.add(node.left);
                horizontalDistanceQueue.add(key - 1);
                mapOfLevelAndNodes.put(key - 1, node.left.val);
            }
            if(node.right != null){
                treeNodeQueue.add(node.right);
                horizontalDistanceQueue.add(key + 1);
                mapOfLevelAndNodes.put(key + 1, node.right.val);
            }
        }
        return new ArrayList<>(mapOfLevelAndNodes.values());
    }


    public static void main(String[] args){
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(3);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(14);
        tree.right = new TreeNode(22);
        tree.right.right = new TreeNode(25);
        BottomViewBinaryTree bt = new BottomViewBinaryTree();
        List<Integer> solution = bt.bottomViewNodes(tree);
        System.out.println(solution);
    }
}
