package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import Notes.DataStructures.TreeNode;

import java.util.*;

public class CousinsInBinaryTree {
    static class TrackParent{
        TreeNode node, parent;
        TrackParent(TreeNode node, TreeNode parent){
            this.node = node;
            this.parent = parent;
        }
    }
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 37.3 MB, less than 7.14%
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TrackParent> queue = new LinkedList<>();
        queue.add(new TrackParent(root, null));
        while(!queue.isEmpty()){
            int size = queue.size();
            TrackParent foundX = null, foundY = null;
            while (size != 0){
                TrackParent trackParent = queue.poll();
                if(trackParent.node.val == x) foundX = trackParent;
                if(trackParent.node.val == y) foundY = trackParent;
                if(trackParent.node.left != null) queue.add(new TrackParent(trackParent.node.left, trackParent.node));
                if(trackParent.node.right != null) queue.add(new TrackParent(trackParent.node.right, trackParent.node));
                size--;
            }
            if(foundX != null && foundY != null) return foundX.parent != foundY.parent;
            // if you come here it means foundX is null
            if(foundY != null || foundX != null) return false; // means you din find one but din find other in the level
        }
    return false; // you din find any
    }
}
