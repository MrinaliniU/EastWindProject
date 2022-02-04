package Notes.Trees.BinarySearchTree;

import Notes.DataStructures.TreeNode;

public class BinarySearchTree {
    public int size;
    public TreeNode root;

    public BinarySearchTree() {

    }

    public void insert(int value){
        if(this.root == null){
            this.root = new TreeNode(value);
        }else {
            insert(value, this.root);
        }
    }

    private void insert(int value, TreeNode treeNode){
        if(value > treeNode.val){
            if(treeNode.right == null){
                treeNode.right = new TreeNode(value);
            }else{
                 insert(value, treeNode.right);
            }
        }else{
            if(treeNode.left == null){
                treeNode.left = new TreeNode(value);
            }else{
                insert(value, treeNode.left);
            }
        }
    }

    public boolean search(int value){
        return searchHelper(value, this.root);
    }

    public boolean searchHelper(int value, TreeNode treeNode){
        if(treeNode.val == value)
            return true;
        else if(value > treeNode.val){
            if(treeNode.right == null)
                return false;
            else
                return searchHelper(value, treeNode.right);
        }else{
            if(treeNode.left == null)
                return false;
            else
                return searchHelper(value, treeNode.left);
        }
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        System.out.println("10 is " + bst.search(10));
        System.out.println("20 is " + bst.search(20));
        bst.insert(20);
        bst.insert(5);
        System.out.println("5 is " + bst.search(5));
        System.out.println("20 is " + bst.search(20));
        bst.insert(-1);
        System.out.println("-1 is " + bst.search(-1));
        System.out.println("-2 is " + bst.search(-2));
        System.out.println("10 is " + bst.search(10));

    }
}
