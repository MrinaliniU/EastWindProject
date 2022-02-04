package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

public class DepthFirstSearch {

    public void inOrder(TreeNode treeNode){
        if(treeNode == null) return;
        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    public void preOrder(TreeNode treeNode){
        if(treeNode == null) return;
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode){
        if(treeNode == null) return;
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    public static void main(String[] args){
        DepthFirstSearch dfs = new DepthFirstSearch();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(15);
        root.left.left.right.right = new TreeNode(11);
        root.left.left.right.right.left = new TreeNode(13);
        root.left.left.right.right.right = new TreeNode(18);
        System.out.print("Pre Order of root = ");
        dfs.preOrder(root);
        System.out.println();
        System.out.print("Post Order of root = ");
        dfs.postOrder(root);
        System.out.println();
        System.out.print("In Order of root = ");
        dfs.inOrder(root);
        System.out.println();
        System.out.println("*****************");
        TreeNode root2 = new TreeNode(200);
        root2.left = new TreeNode(150);
        root2.right = new TreeNode(-100);
        root2.left.left = new TreeNode(30);
        root2.left.right = new TreeNode(-50);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(90);
        root2.left.right.left = new TreeNode(60);
        root2.left.right.right = new TreeNode(13);
        root2.right.right.left = new TreeNode(15);
        root2.right.right.right = new TreeNode(-11);
        root2.left.right.right.left = new TreeNode(-10);
        root2.left.right.right.right = new TreeNode(19);
        System.out.print("Pre Order of root2 = ");
        dfs.preOrder(root2);
        System.out.println();
        System.out.print("Post Order of root2 = ");
        dfs.postOrder(root2);
        System.out.println();
        System.out.print("In Order of root2 = ");
        dfs.inOrder(root2);
        System.out.println();
        System.out.println("*****************");
        TreeNode bst = new TreeNode(200);
        bst.left = new TreeNode(150);
        bst.right = new TreeNode(206);
        bst.left.left = new TreeNode(100);
        bst.right.right = new TreeNode(210);
        bst.left.left.left = new TreeNode(90);
        bst.left.left.right = new TreeNode(125);
        bst.left.left.right.right = new TreeNode(135);
        bst.left.left.right.right.left = new TreeNode(130);
        bst.left.left.right.right.right = new TreeNode(140);
        System.out.print("Pre Order of bst = ");
        dfs.preOrder(bst);
        System.out.println();
        System.out.print("Post Order of bst = ");
        dfs.postOrder(bst);
        System.out.println();
        System.out.print("In Order of bst = ");
        dfs.inOrder(bst);
        System.out.println();
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        completeBinaryTree.insert(1);
        completeBinaryTree.insert(2);
        completeBinaryTree.insert(3);
        completeBinaryTree.insert(4);
        completeBinaryTree.insert(5);
        completeBinaryTree.insert(6);
        completeBinaryTree.insert(7 );
        /*dfs.inOrder(completeBinaryTree.root);
        System.out.println();
        dfs.preOrder(completeBinaryTree.root);
        System.out.println();
        dfs.postOrder(completeBinaryTree.root);*/
    }
}
