package Notes.Graphs.Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Dijkstra {
    int[] cost;

    public int shortestPath(int[][] matrix, int source, int destination){
        cost = new int[matrix.length];
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[source] = 0;
        for(int i = 0; i < matrix.length; i++){
            int node = getSmallestCostNode(cost, visited);
            visited[node] = true;
            if(node == destination) return cost[destination];
            for(int neighbour = 0; neighbour < matrix.length; neighbour++){
                if(matrix[node][neighbour] != 0 && !visited[neighbour] && cost[node] != Integer.MAX_VALUE
                && cost[node] + matrix[node][neighbour] < cost[neighbour]){
                    cost[neighbour] = cost[node] + matrix[node][neighbour];
                }
            }
        }
        return cost[destination];
    }

    int getSmallestCostNode(int[] cost, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < cost.length; i++){
            if(visited[i]) continue;
            if(cost[i] < min) {
                minIndex = i;
                min = cost[i];
            }
        }
        return minIndex;
    }

    public HashMap<Integer, HashSet<Integer>> getGraph(int[][] matrix){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] > 0) {
                    graph.putIfAbsent(i, new HashSet<>());
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }

    public static void main(String[] args){
        Dijkstra d = new Dijkstra();
        int[][] matrix = {{0, 5, 0, 9, 0, 2},
                {5, 0, 2, 0, 0, 0},
                {0, 2, 0, 3, 0, 0},
                {0, 0, 3, 0, 2, 0},
                {0, 0, 0, 2, 0, 3},
                {2, 0, 0, 0, 3, 0}};

        System.out.print(d.shortestPath(matrix, 0, 3));
    }
}
