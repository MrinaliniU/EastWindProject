package Notes.PriorityQueue;

import java.util.PriorityQueue;

/*
Given n ropes of different lengths, we need to connect these ropes into one rope.
We can connect only 2 ropes at a time.
The cost required to connect 2 ropes is equal to sum of their lengths.
The length of this connected rope is also equal to the sum of their lengths.
This process is repeated until n ropes are connected into a single rope.
Find the min possible cost required to connect all ropes.
*******************************************************
Input: ropes = [8, 4, 6, 12]
Output: 58
Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
3. Connect the ropes of length 18 and 12 (cost is 30).
Total cost to connect the ropes is 10 + 18 + 30 = 58
********************************************************
 */
public class MinCostToConnectRopes {

    public int minCost(int[] ropes){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cost = 0;
        for(int rope : ropes) queue.add(rope);
        while (!queue.isEmpty()){
            if(queue.size() <= 1) break;
            int _cost = queue.poll() + queue.poll();
            queue.add(_cost);
            cost += _cost;
        }
        return cost;
    }
    public static void main(String[] args){
        MinCostToConnectRopes r = new MinCostToConnectRopes();
        int[] ropes = {8, 4, 6, 12}; // 58
        int[] ropes2 = {20, 4, 8, 2}; // 54
        int[] ropes3 = {1, 2, 5, 10, 35, 89}; // 244
        int[] ropes4 = {2, 2, 3, 3}; // 20
        System.out.println(r.minCost(ropes));
        System.out.println(r.minCost(ropes2));
        System.out.println(r.minCost(ropes3));
        System.out.println(r.minCost(ropes4));
    }
}
