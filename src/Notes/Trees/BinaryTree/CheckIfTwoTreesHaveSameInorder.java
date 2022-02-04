package Notes.Trees.BinaryTree;

import Notes.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CheckIfTwoTreesHaveSameInorder {
    public static boolean same(TreeNode t1, TreeNode t2){
        List<Integer> l1 = new ArrayList<>(); // store tree one inorder
        inorder(t1, l1);
        return inorderC(t2, l1);
    }

    public static boolean inorderC(TreeNode t, List<Integer> l){
        if(t == null) return true;
        if(!inorderC(t.left, l)) return false;
        if(l.isEmpty() || l.get(0) != t.val) return false;
        l.remove(0);
        return !inorderC(t.right, l);
    }

    public static void inorder(TreeNode t, List<Integer> l){
        if(t == null) return;
        inorder(t.left, l);
        l.add(t.val);
        inorder(t.right, l);
    }
    public static void main(String[] args){

    }
}
