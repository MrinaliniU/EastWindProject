package Notes.Graphs.Algorithms;

import java.util.*;

// Articulation points or cut vertices are vertices that when removed from graph
// results in disconnected graph
public class Tarjan {
    int time = 0;
    boolean[] visited;
    int[] parents;
    int[] discoverTime;
    int[] backEdgeNode_lowTime;
    /*
        1. Form a dfs spanning tree in other words you will be traversing the graph in dfs
        2. While traversing for each node list down the order in which it was traversed (discoveryTime)
     */
    List<Integer> articulationPoints(int numNodes, int numEdges, int[][] edges){
        /* This is an undirected graph so every node should have ALL of it's node added as neighbors
        * {0, 1} means 0 has 1 as neighbor and 1 has 0 as neighbour */
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> articulationPoints = new ArrayList<>();

        visited = new boolean[numNodes];
        parents = new int[numNodes];
        Arrays.fill(parents, -1);
        discoverTime = new int[numNodes];
        backEdgeNode_lowTime = new int[numNodes];
        dfsHelper(1, graph, articulationPoints);
        return articulationPoints;
    }

    public void dfsHelper(int node, HashMap<Integer, HashSet<Integer>> graph,  List<Integer> articulationPoints){
        visited[node] = true;
        discoverTime[node] = time;
        backEdgeNode_lowTime[node] = time;
        time++;
        int childCount = 0;
        boolean isArticulationNode = false;
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                childCount++;
                parents[neighbor] = node;
                dfsHelper(neighbor, graph, articulationPoints);
                if(discoverTime[node] <= backEdgeNode_lowTime[neighbor]) isArticulationNode = true;
                else backEdgeNode_lowTime[node] = Math.min(backEdgeNode_lowTime[node], backEdgeNode_lowTime[neighbor]);
            }
            else backEdgeNode_lowTime[node] = Math.min(backEdgeNode_lowTime[node], discoverTime[neighbor]);
        }
        if(parents[node] == -1 && childCount >= 2 || parents[node] != -1 && isArticulationNode) articulationPoints.add(node);

    }
    public static void main(String[] args){
        int numNodes = 4, numEdges = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        /*int numNodes = 8, numEdges = 9;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {3, 4}, {4, 6}, {6, 5}, {5, 4}, {7, 5}};*/

        /*int numNodes = 7, numEdges = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};*/
        Tarjan a = new Tarjan();
        List<Integer> articulationPoints = a.articulationPoints(numNodes, numEdges, edges);
        for(int articulationPoint : articulationPoints){
            System.out.print(articulationPoint + " ");
        }
    }
}
