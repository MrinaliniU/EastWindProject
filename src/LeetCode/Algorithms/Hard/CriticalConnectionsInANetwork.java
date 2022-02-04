package LeetCode.Algorithms.Hard;
import java.util.*;
public class CriticalConnectionsInANetwork {
    int time = 0;
    int[] discoverTime;
    int[] parents;
    int[] backTime;
    boolean[] visited;
    List<List<Integer>> critical_edges;
    HashMap<Integer, HashSet<Integer>> graph;
    /*
        Runtime: 261 ms, faster than 7.40%
        Memory Usage: 150.4 MB, less than 100.00%
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /* Prepare the graph */
        parents = new int[n];
        Arrays.fill(parents, -1);
        discoverTime = new int[n];
        backTime = new int[n];
        visited = new boolean[n];
        graph = new HashMap<>();
        critical_edges = new ArrayList<>();
        for(List<Integer> connection : connections){
            graph.putIfAbsent(connection.get(0), new HashSet<>());
            graph.get(connection.get(0)).add(connection.get(1));
            graph.putIfAbsent(connection.get(1), new HashSet<>());
            graph.get(connection.get(1)).add(connection.get(0));
        }
        dfs(0);
        return critical_edges;
    }

    public void dfs(int node){
        backTime[node] = discoverTime[node] = time++;
        // Visit this node
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            /* If my Neighbor is my parent skip for loop*/
            if(neighbor == parents[node]) continue;
            if(!visited[neighbor]){
                parents[neighbor] = node;
                dfs(neighbor);
                backTime[node] = Math.min(backTime[node], backTime[neighbor]);
                if(discoverTime[node] < backTime[neighbor]) critical_edges.add(Arrays.asList(node, neighbor));
            }
            else backTime[node] = Math.min(backTime[node], discoverTime[neighbor]);
        }
    }
    public static void main(String[] args){
        CriticalConnectionsInANetwork cn = new CriticalConnectionsInANetwork();
        /*List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        List<List<Integer>> critical_edges = cn.criticalConnections(3, connections);*/
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));
        List<List<Integer>> critical_edges = cn.criticalConnections(4, connections);
        for(List<Integer> i : critical_edges) System.out.println(i);
    }
}
