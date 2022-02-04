package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
import Notes.DataStructures.TreeNode;

import java.util.*;
public class BinaryTreeLevelOrderTraversal {

    /*
        DFS
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39.3 MB, less than 5.33%
     */
    List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root){
        answer = new ArrayList<>();
        dfs(root, 0);
        return answer;
    }
    public void dfs(TreeNode node, int level){
        if(node == null) return;
        if(answer.size() == level) answer.add(new ArrayList<>());
        answer.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
    /*
        BFS
        Runtime: 1 ms, faster than 56.79%
        Memory Usage: 39.2 MB, less than 5.33%
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queue_size = queue.size();
            levelOrder.add(new ArrayList<>());
            while(queue_size  != 0){
                TreeNode node = queue.poll();
                levelOrder.get(levelOrder.size() - 1).add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                queue_size--;
            }
        }
        return levelOrder;
    }

    public static void main(String[] args){
        BinaryTreeLevelOrderTraversal br = new BinaryTreeLevelOrderTraversal();
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
        List<List<Integer>> result = br.levelOrder2(bst);
        for(List<Integer> r : result) System.out.println(r);
    }
}
