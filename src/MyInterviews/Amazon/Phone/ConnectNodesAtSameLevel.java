package MyInterviews.Amazon.Phone;

import java.util.*;
/* Completed */
public class ConnectNodesAtSameLevel {
    static class TreeNode{
        int val;
        TreeNode left, right, next;
        TreeNode(int val){
            this.val = val;
        }
    }

    public void connectNodesAtSameLevel(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode previous = null;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            while (queueSize > 0){
                TreeNode T = queue.poll();
                if(previous != null) previous.next = T;
                previous = T;
                System.out.print(T.val + " ");
                if(T.left != null) queue.add(T.left);
                if(T.right != null) queue.add(T.right);
                queueSize--;
            }
            previous = null;
            System.out.println();
        }
    }

    public void print_bfs_next(TreeNode root){
        Queue<TreeNode> print_queue = new LinkedList<>();
        print_queue.add(root);
        while (!print_queue.isEmpty()){
            int queue_size = print_queue.size();
            while (queue_size > 0){
                TreeNode T = print_queue.poll();
                if(T.next != null)
                    System.out.print(T.val + "->" + T.next.val + " ");
                else
                    System.out.print(T.val + "--->");
                if(T.left != null) print_queue.add(T.left);
                if(T.right != null) print_queue.add(T.right);
                queue_size--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        ConnectNodesAtSameLevel cs  = new ConnectNodesAtSameLevel();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Before Connection");
        cs.connectNodesAtSameLevel(root);
        System.out.println("After Connection");
        cs.print_bfs_next(root);
    }
}
