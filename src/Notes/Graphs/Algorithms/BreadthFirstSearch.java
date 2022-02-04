package Notes.Graphs.Algorithms;

import java.util.*;

public class BreadthFirstSearch {

    public void breadthFirstSearchDirected(int numberOfNodes, int[][] edges){
        HashMap<Integer, List<Integer>> graph = getDirectedGraph(numberOfNodes, edges);
        boolean[] visited = new boolean[numberOfNodes]; // to avoid cycle
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            List<Integer> G = graph.get(node);
            System.out.print(node + " ");
            if(G == null) continue;
            for(int i : G)
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
        }
    }
    public void breadthFirstSearchUnDirected(int numberOfNodes, int[][] edges){
        HashMap<Integer, List<Integer>> graph = getUndirectedGraph(numberOfNodes, edges);
        boolean[] visited = new boolean[numberOfNodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node + " ");
            List<Integer> neighbors = graph.get(node);
            if(neighbors == null) continue;
            for(int n : neighbors){
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public HashMap<Integer, List<Integer>> getUndirectedGraph(int numberOfNodes, int[][] edges){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public HashMap<Integer, List<Integer>> getDirectedGraph(int numberOfNodes, int[][] edges){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    public static void main(String[] args){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        /* List of edges are given */
        int numNodes = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        int numNodes_cycle = 4;
        int[][] edges_cycle = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 1}};
        System.out.println("Print BFS of a Directed Graph No Cycle");
        bfs.breadthFirstSearchDirected(numNodes, edges);
        System.out.println();
        System.out.println("Print BFS of a Directed Graph With Cycle");
        bfs.breadthFirstSearchDirected(numNodes_cycle, edges_cycle);
        System.out.println();
        System.out.println("Print BFS of a Un-Directed Graph");
        bfs.breadthFirstSearchUnDirected(numNodes, edges);
        /* A grid is given with 1 representing a connection at <row, column>*/
        int[][] grid = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};
    }
}
