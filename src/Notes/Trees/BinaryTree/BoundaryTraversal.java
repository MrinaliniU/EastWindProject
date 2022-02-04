package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

public class BoundaryTraversal {
    public void printBoundary(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    /* In order template */
    public void printLeaves(TreeNode node){
        if(node == null) return;
        printLeaves(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.val + " ");
        printLeaves(node.right);
    }
    /* */
    public void printLeftBoundary(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            System.out.print(node.val + " "); // top down print
            printLeftBoundary(node.left);
        }else if(node.right != null){
            System.out.print(node.val + " "); // top down print
            printLeftBoundary(node.right);
        }
        // if both left and right are null then it's leaf node don't print
    }

    public void printRightBoundary(TreeNode node){
        if(node == null) return;
        if(node.right != null){
            printRightBoundary(node.right);
            System.out.print(node.val + " ");
        }else if(node.left != null){
            printRightBoundary(node.left);
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args){
        BoundaryTraversal bt = new BoundaryTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        /* -------------------------------------------- */
        TreeNode root1 = new TreeNode(200);
        root1.left = new TreeNode(150);
        root1.right = new TreeNode(206);
        root1.left.left = new TreeNode(100);
        root1.right.right = new TreeNode(210);
        root1.left.left.left = new TreeNode(90);
        root1.left.left.right = new TreeNode(125);
        root1.left.left.right.right = new TreeNode(135);
        root1.left.left.right.right.left = new TreeNode(130);
        root1.left.left.right.right.right = new TreeNode(140);
        bt.printBoundary(root1);
    }
}
