package Notes.DataStructures;

import java.util.*;

public class Graph <T>{
    private HashMap<T, ArrayList<T>> adjacencyListMap;
    private ArrayList<T> uniqueVertices;
    HashMap<T, Integer> vertex_index;
    public Graph (T[][] adjacencyMatrix){
        this.adjacencyListMap = new HashMap<>();
        addAllEdges(adjacencyMatrix);
        uniqueVertices(adjacencyMatrix);
    }
    public ArrayList<T> getUniqueVertices() { return uniqueVertices; }
    public HashMap<T, Integer> getVertex_index() { return vertex_index; }
    public HashMap<T, ArrayList<T>> getAdjacencyListMap(){
        return this.adjacencyListMap;
    }

    private void addAllEdges(T[][] adjacencyMatrix){
        for (T[] a : adjacencyMatrix) {
            addEdges(a[0], a[1]);
        }
    }
    private void addEdges(T u, T v){
        this.adjacencyListMap.putIfAbsent(u, new ArrayList<>());
        this.adjacencyListMap.get(u).add(v);
    }

    private void uniqueVertices(T[][] adjacencyMatrix){
        int value = 0;
        Set<T> set = new HashSet<>();
        uniqueVertices = new ArrayList<>();
        vertex_index = new HashMap<>();
        for(T[] a : adjacencyMatrix) Collections.addAll(set, a);
        for(T t : set){
            vertex_index.put(t, value++);
            uniqueVertices.add(t);
        }
    }

}
