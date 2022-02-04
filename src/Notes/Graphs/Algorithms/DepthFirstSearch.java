package Notes.Graphs.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepthFirstSearch {

    public void dfsGivenGrid(int[][] edges){
        /* Read the grid to make a map of edges */
    }
    public void dfsGivenListOfEdges(int numNodes, int numEdges, int[][] edges){
        /* You know number of nodes and edges */
        /* Store edges as key value pairs */
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            List<Integer> l = map.getOrDefault(edge[0], new ArrayList<>());
            l.add(edge[1]);
            map.put(edge[0], l);
        }
        boolean[] visited = new boolean[numNodes];
        dfsHelperOne(0, map, visited);
    }
    public void dfsHelperOne(int node, HashMap<Integer, List<Integer>> edges, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");
        List<Integer> neighbors = edges.get(node);
        if(neighbors == null) return; // this is the base case for recursion
        for(Integer neighbor : neighbors){
            if(!visited[neighbor]) dfsHelperOne(neighbor, edges, visited);
        }
    }
    public static void main(String[] args){
        DepthFirstSearch dfs = new DepthFirstSearch();
        /* List of edges are given */
        int numNodes = 7, numEdges = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        /* A grid is given with 1 representing a connection at <row, column>*/
        int[][] grid = {{0, 1, 1, 0, 1},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0}};
        dfs.dfsGivenListOfEdges(numNodes, numEdges, edges);
    }
}
