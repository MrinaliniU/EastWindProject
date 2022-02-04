package LeetCode.Algorithms.Medium;
import java.util.*;
/*
Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30
 */
public class MinCostToMergeSticks {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int stick : sticks){
            queue.add(stick);
        }
        while(!queue.isEmpty()){
            if(queue.size() <= 1) break;
            int _cost = queue.poll() + queue.poll();
            queue.add(_cost);
            cost += _cost;
        }
        return cost;
    }

    public static void main(String[] args){
        MinCostToMergeSticks mc = new MinCostToMergeSticks();
        int[] sticks = {1,8,3,5};
        System.out.println(mc.connectSticks(sticks));
    }
}
