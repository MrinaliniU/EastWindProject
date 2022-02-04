package ElementsOfProgrammingInterview.StacksAndQueues;

import Notes.DataStructures.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ComputeBinaryTreeInOrderOfIncreasingDepth {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<Pair<TreeNode, Integer>> nodesQueue = new ArrayDeque<>();
        nodesQueue.add(new Pair<>(root, 0));
        while (!nodesQueue.isEmpty()) {
            Pair<TreeNode, Integer> element = nodesQueue.pollFirst();
            Integer depth = element.getValue();
            TreeNode node = element.getKey();
            if (depth == result.size()) {
                List<Integer> newList = new ArrayList<>();
                newList.add(node.val);
                result.add(newList);
            } else {
                result.get(depth).add(node.val);
            }
            if (node.left != null) {
                nodesQueue.addLast(new Pair<>(node.left, depth + 1));
            }

            if (node.right != null) {
                nodesQueue.addLast(new Pair<>(node.right, depth + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(314);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(271);
        root.left.right = new TreeNode(561);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(271);
        root.left.left.left = new TreeNode(28);
        root.left.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        root.right.right.right = new TreeNode(28);
        root.left.right.right.left = new TreeNode(17);
        root.right.left.right.left = new TreeNode(401);
        root.right.left.right.right = new TreeNode(257);
        root.right.left.right.left.right = new TreeNode(641);
        System.out.println(traverse(root));
    }
}
