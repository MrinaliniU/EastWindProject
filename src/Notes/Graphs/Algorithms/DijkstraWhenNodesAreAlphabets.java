package Notes.Graphs.Algorithms;

import java.util.*;

// SINGLE SOURCE SHORTEST PATH PROBLEM
public class DijkstraWhenNodesAreAlphabets {
    // You can pass either directed or undirected graph into it
    public int getShortestPath(HashMap<Character, HashMap<Character, Integer>> graph, int s, int d, List<Character> allNodes){
        boolean[] visited =  new boolean[26];
        int[] cost = new int[26];
        Arrays.fill(cost, Integer.MAX_VALUE);
        // set source cost as 0
        cost[s - 65] = 0;
        for(int i = 0; i < allNodes.size(); i++){
            Character node = getSmallestCostNode(cost, visited); // this should give A at the beginning
            if(node == d) return cost[d - 65]; // you are at the destination return the cost
            // mark this node visited
            visited[node - 65] = true;
            // get the neighbors of the node
            HashMap<Character, Integer> neighbors = graph.get(node);
            int cost_of_node = cost[node - 65];
            if(neighbors == null) continue;
            for(Map.Entry<Character, Integer> neighbor : neighbors.entrySet()){
                // if neighbor is visited continue
                Character n = neighbor.getKey();
                // Perform relaxation only if the node is not visited.
                if(!visited[n - 65]) {
                    int cost_of_n = cost[n - 65];
                    int edge_cost = neighbor.getValue();
                    if (cost_of_node + edge_cost < cost_of_n) cost[n - 65] = cost_of_node + edge_cost;
                }
            }
        }
        return cost[d - 65];
    }
    /* Returns the node with smallest node that is not visited */
    Character getSmallestCostNode(int[] cost, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < cost.length; i++){
            if(visited[i]) continue;
            if(cost[i] < min) {
                min = cost[i];
                minIndex = i;
            }
        }
        return (char) (minIndex + 65);
    }
    /* Get all nodes in graph */
    List<Character> getAllNodes_directed(char[][] edges){
        HashSet<Character> nodes = new HashSet<>();
        for(char[] edge : edges){
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        return new ArrayList<>(nodes);
    }
    // for directed graph
    public int getShortestPath_directed(char[][] edges, int s, int d){
        HashMap<Character, HashMap<Character, Integer>> graph = getDirectedGraph(edges);
        List<Character> allNodes = getAllNodes_directed(edges);
        return getShortestPath(graph, s, d, allNodes);
    }
    // for un directed graph
    public int getShortestPath_undirected(char[][] edges, int s, int d){
        HashMap<Character, HashMap<Character, Integer>> graph = getUnDirectedGraph(edges);
        return getShortestPath(graph, s, d, new ArrayList<>(graph.keySet()));
    }
    /* Directed Graph */
    public HashMap<Character, HashMap<Character, Integer>> getDirectedGraph(char[][] edges){
        HashMap<Character, HashMap<Character, Integer>> _graph = new HashMap<>();
        for(char[] edge : edges){
            _graph.putIfAbsent(edge[0], new HashMap<>());
            _graph.get(edge[0]).put(edge[1], (int) edge[2]);
        }
        return _graph;
    }
    /* UnDirected Graph */
    public HashMap<Character, HashMap<Character, Integer>> getUnDirectedGraph(char[][] edges){
        HashMap<Character, HashMap<Character, Integer>> _graph = new HashMap<>();
        for(char[] edge : edges){
            _graph.putIfAbsent(edge[0], new HashMap<>());
            _graph.get(edge[0]).put(edge[1], (int) edge[2]);
            _graph.putIfAbsent(edge[1], new HashMap<>());
            _graph.get(edge[1]).put(edge[0], (int) edge[2]);
        }
        return _graph;
    }
    public static void main(String[] args){
        DijkstraWhenNodesAreAlphabets d = new DijkstraWhenNodesAreAlphabets();
        /* Consider below graph to be directed graph
                A B C
                D E F
        * */
        char[][] edges = {{'A', 'D', 10}, {'A', 'B', 50}, {'A', 'C', 45}, {'B', 'C', 10}, {'B', 'D', 15},
                {'C', 'E', 30}, {'D', 'A', 10}, {'D', 'E', 15}, {'E', 'B', 20}, {'E', 'C', 35}, {'F', 'E', 3}};
        System.out.println("******** For Directed Graph 1 **********");
        System.out.println("Get Shortest Path from A to E = " + d.getShortestPath_directed(edges, 'A', 'E'));
        /* consider the below graph to be un-directed graph
              B C D
           A    I    E
              H G F

        * */
        char[][] edges2 = {{'A', 'B', 4}, {'A', 'H', 8}, {'B', 'H', 11}, {'B', 'C', 8}, {'H', 'I', 7},
                {'H', 'G', 1}, {'C', 'I', 2}, {'I', 'G', 6}, {'C', 'F', 4}, {'C', 'D', 7}, {'D', 'F', 14},
                {'D', 'E', 9}, {'E', 'F', 10}, {'G', 'F', 2}};
        // Answer shortest distance from A to all nodes in alphabetic order
        // 0 4 12 19 21 11 9 8 14
        System.out.println("******** For Un Directed Graph 2 **********");
        System.out.println("Get Shortest Path from A to A = " + d.getShortestPath_undirected(edges2, 'A', 'A'));
        System.out.println("Get Shortest Path from A to B = " + d.getShortestPath_undirected(edges2, 'A', 'B'));
        System.out.println("Get Shortest Path from A to C = " + d.getShortestPath_undirected(edges2, 'A', 'C'));
        System.out.println("Get Shortest Path from A to D = " + d.getShortestPath_undirected(edges2, 'A', 'D'));
        System.out.println("Get Shortest Path from A to E = " + d.getShortestPath_undirected(edges2, 'A', 'E'));
        System.out.println("Get Shortest Path from A to F = " + d.getShortestPath_undirected(edges2, 'A', 'F'));
        System.out.println("Get Shortest Path from A to G = " + d.getShortestPath_undirected(edges2, 'A', 'G'));
        System.out.println("Get Shortest Path from A to H = " + d.getShortestPath_undirected(edges2, 'A', 'H'));
        System.out.println("Get Shortest Path from A to I = " + d.getShortestPath_undirected(edges2, 'A', 'I'));
    }
}
