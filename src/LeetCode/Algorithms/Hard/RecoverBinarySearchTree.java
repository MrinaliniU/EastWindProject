package LeetCode.Algorithms.Hard;

import Notes.DataStructures.TreeNode;

import java.util.*;
/*
    There are four solution for this problem, (H is height of three).
        1. Naive - O(N) time and O(N) space
        2. Recursive - O(N) worst case O(H) space
        3. Iterative - O(N) worst case O(H) space
        4. Morris InOrder - O(N) time O(1) space
 */

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        /* Runtime: 3 ms, faster than 38.39%, Memory Usage: 40.1 MB, less than 80.77% */
        naive(root);
        // recurse(root);
        //iterative(root);
        // morrisInOrder(root);
    }

    /* -----------------------------NAIVE--------------------------------------- */
    public void naive(TreeNode root){
        /* Get the in order numbers in an array */
        List<Integer> store = new ArrayList<>();
        inOrder(root, store);
        /* Find the two numbers that are swapped */
        int[] swapped = getSwappedNumbers(store);
        /* Iterate tree and replace the elements */
        fixTree(root, 2, swapped[0], swapped[1]);
    }
    public void fixTree(TreeNode node, int fixCount, int x, int y){
        if(node == null || fixCount <= 0) return;
        if(node.val == x || node.val == y){
            node.val = node.val == x ? y : x;
            fixCount--;
        }
        fixTree(node.left, fixCount, x, y);
        fixTree(node.right, fixCount, x, y);
    }
    int[] getSwappedNumbers(List<Integer> store){
        int x = -1, y = -1;
        for(int i = 0; i < store.size() - 1; i++){
            if(store.get(i + 1) < store.get(i)){
                y = store.get(i + 1);
                if(x == -1) x = store.get(i);
                else break;
            }
        }
        return new int[]{x, y};
    }
    public void inOrder(TreeNode node, List<Integer> store){
        if(node == null) return;
        inOrder(node.left, store);
        store.add(node.val);
        inOrder(node.right, store);
    }
    /* -------------------------------------------------------------------------- */
    /* -----------------------------RECURSE--------------------------------------- */
    /*
        This approach is your day to day in order traversal routine which has additional check
        to find the node with values that have been swapped
        Runtime: 2 ms, faster than 78.80% , Memory Usage: 44.2 MB, less than 61.54%
     */

    public void recurse(TreeNode root){
        TreeNode nodeX = null, nodeY = null, previousNode = null;
        findTwoNodeToSwap(root, nodeX, nodeY, previousNode);
        swap(nodeX, nodeY);
    }
    private void findTwoNodeToSwap(TreeNode node, TreeNode nodeX, TreeNode nodeY, TreeNode previousNode){
        if(node == null) return;
        findTwoNodeToSwap(node.left, nodeX, nodeY, previousNode);
        /* Logic to find two nodes */
        if(previousNode != null &&  node.val < previousNode.val){
            nodeY = node;
            if(nodeX == null) nodeX = previousNode;
            else return;
        }
        previousNode = node;
        findTwoNodeToSwap(node.left, nodeX, nodeY, previousNode);
    }
    /* -------------------------------------------------------------------------- */
    /* -----------------------------ITERATE--------------------------------------- */
    /* This logic is based on Iterative approach to InOrder Traversal
    * While you traverse in such fashion you simply use the logic to finding the
    * swapped element and swap back these two node vals to  recover the binary search tree
    * Runtime: 2 ms, faster than 78.80%, Memory Usage: 40.2 MB, less than 80.77%*/
    public void iterative(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode previousNode = null, nodeX = null, nodeY = null;
        while(!stack.isEmpty() || root != null){
            while (root != null){
                stack.offer(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(previousNode != null && root.val < previousNode.val){
                nodeY = root;
                if(nodeX == null) nodeX = previousNode;
                else break;
            }
            previousNode = root;
            root = root.right;
        }
        swap(nodeX, nodeY);
    }
    private void swap(TreeNode nodeX, TreeNode nodeY){
        int temp = nodeX.val;
        nodeX.val = nodeY.val;
        nodeY.val = temp;
    }
    /* -----------------------------MORRIS--------------------------------------- */
    public void morrisInOrder(TreeNode root){

    }
}
