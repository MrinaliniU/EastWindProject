package Notes.Graphs;

import Notes.DataStructures.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/******************************* This has to be worked on see the way it prints the integer graph and the string graph */
public class ToDoBreadthFirstSearch {

    public void breadthFirstSearch(String[][] edges){
        Graph<String> graph = new Graph<>(edges);
        int numberOfIslands = 0;
        /* Need this to get index of a letter say "A" in O(N) time.*/
        HashMap<String, Integer> vertex_index = graph.getVertex_index();
        /* need this to get a letter say "A" at a specific index in O(N) time*/
        ArrayList<String> uniqueVertices = graph.getUniqueVertices();
        boolean[] visitedVertices = new boolean[vertex_index.size()];
        HashMap<String, ArrayList<String>> adjacencyListMap = graph.getAdjacencyListMap();
        for(int i = 0; i < visitedVertices.length; i++){
            if(!visitedVertices[i]){
                numberOfIslands++;
                breadthFirstSearch(adjacencyListMap, visitedVertices, vertex_index, uniqueVertices.get(i));
            }
        }
        System.out.println();
        System.out.println("The number of islands in the given graph is " + numberOfIslands);
    }
    public void breadthFirstSearch(Integer[][] edges){
        Graph<Integer> graph = new Graph<>(edges);
        int numberOfIslands = 0;
        /* Need this to get index of a letter say "A" in O(N) time.*/
        HashMap<Integer, Integer> vertex_index = graph.getVertex_index();
        /* need this to get a letter say "A" at a specific index in O(N) time*/
        ArrayList<Integer> uniqueVertices = graph.getUniqueVertices();
        boolean[] visitedVertices = new boolean[vertex_index.size()];
        HashMap<Integer, ArrayList<Integer>> adjacencyListMap = graph.getAdjacencyListMap();
        for(int i = 0; i < visitedVertices.length; i++){
            if(!visitedVertices[i]){
                numberOfIslands++;
                breadthFirstSearch(adjacencyListMap, visitedVertices, vertex_index, uniqueVertices.get(i));
            }
        }
        System.out.println();
        System.out.println("The number of islands in the given graph is " + numberOfIslands);
    }
    public void breadthFirstSearch(HashMap<String, ArrayList<String>> adjacencyListMap,
                                   boolean[] visitedVertices, HashMap<String, Integer> uniqueVertices, String start){
       visitedVertices[uniqueVertices.get(start)] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            String s = queue.poll();
            System.out.print(s + " ");
            ArrayList<String> adjacentList = adjacencyListMap.get(s);
            if(adjacentList != null){
                for(String temp : adjacentList){
                    if(!visitedVertices[uniqueVertices.get(temp)]){
                        visitedVertices[uniqueVertices.get(temp)] = true;
                        queue.add(temp);
                    }
                }
            }
        }
    }

    public void breadthFirstSearch(HashMap<Integer, ArrayList<Integer>> adjacencyListMap,
                                   boolean[] visitedVertices, HashMap<Integer, Integer> uniqueVertices, int start){
        visitedVertices[uniqueVertices.get(start)] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int s = queue.poll();
            System.out.print(s + " ");
            ArrayList<Integer> adjacentList = adjacencyListMap.get(s);
            if(adjacentList != null){
                for(Integer temp : adjacentList){
                    if(!visitedVertices[uniqueVertices.get(temp)]){
                        visitedVertices[uniqueVertices.get(temp)] = true;
                        queue.add(temp);
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        // fully connected graph
        String[][] graph1Edges = {{"A", "B"}, {"A", "C"}, {"A", "D"}, {"B", "E"},
                {"C", "E"}, {"C", "H"}, {"C", "G"}, {"D", "F"}, {"D", "G"}, {"G", "H"}};
        Integer[][] graph3Edges = {{100, 30}, {100, 50}, {30, 75}, {50, 75}, {50, 80}, {33, 75}, {80, 90}, {90, 45}};
        // disconnected graph
        String[][] graph2Edges = {{"A", "B"}, {"A", "C"}, {"A", "D"}, {"B", "D"}, {"C", "B"}, {"X", "Y"}};
        ToDoBreadthFirstSearch bfs = new ToDoBreadthFirstSearch();
        bfs.breadthFirstSearch(graph1Edges);
        System.out.println();
        bfs.breadthFirstSearch(graph2Edges);
        System.out.println();
        bfs.breadthFirstSearch(graph3Edges);
    }
}
