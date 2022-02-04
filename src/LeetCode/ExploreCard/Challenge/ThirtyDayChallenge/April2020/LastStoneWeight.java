package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.*;

public class LastStoneWeight {
    /*
        Runtime: 3 ms
        Memory Usage: 38.6 MB
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int i : stones) queue.add(i);
        while (!queue.isEmpty()){
            if(queue.size() == 1) break;
            Integer x = queue.poll();
            Integer y = queue.poll();
            if(!x.equals(y)) queue.add(Math.abs(x - y));
        }
        return queue.size() == 1 ? queue.poll() : 0;
    }

    public static void main(String[] args){
        LastStoneWeight lw = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Weights " + lw.lastStoneWeight(stones));
    }
}
