package LeetCode.Algorithms.Medium;

import java.util.*;
/*
    Read http://buttercola.blogspot.com/2016/01/leetcode-minimum-height-trees.html
    Idea is to remove leaf nodes level by level till either one or two nodes are left.

 */
public class MinimumHeightTrees {
    List<Integer> result;
    /*
        Runtime: 21 ms, faster than 40.08%
        Memory Usage: 41.2 MB, less than 100.00%
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        result = new ArrayList<>();
        if(n == 1 && edges.length == 0) {
            result.add(0);
            return result;
        }
        if(n == 2 && edges.length == 1){
            result.add(0);
            result.add(1);
            return result;
        }
        List<Set<Integer>> graph = getGraph(n, edges);
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++){
            if(graph.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2){
            n -= leaves.size();
            List<Integer> newLeaf = new ArrayList<>();
            for(int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size() == 1) newLeaf.add(neighbor);
            }
            leaves = newLeaf;
        }
        return leaves;
    }

    List<Set<Integer>> getGraph(int n, int[][] edges){
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new HashSet<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    /*
        FASTER
     */
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) list.add(i);
        }
        return prone(map, list);
    }

    private List<Integer> prone(Map<Integer, List<Integer>> map, List<Integer> leaves) {
        if (map.size() <= 2) return new ArrayList<>(map.keySet());
        List<Integer> list = new ArrayList<>();
        for (Integer leaf : leaves) {
            Integer neighbor = map.get(leaf).get(0);
            map.get(neighbor).remove(leaf);
            if (map.get(neighbor).size() == 1) list.add(neighbor);
            map.remove(leaf);
        }
        return prone(map, list);
    }
}
