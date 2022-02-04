package ElementsOfProgrammingInterview;

import Notes.DataStructures.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SandBox {

    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return traverse(root, k);
    }

    private boolean traverse(TreeNode node, int k) {
        if (node == null) return false;
        if (set.contains(node.val)) return true;
        int sub = k - node.val;
        set.add(sub);
        if (sub >= node.val) return traverse(node.right, k);
        return traverse(node.left, k);
    }


    public static void main(String[] args) {
    }

}
