package Notes.Graphs.Problems;

import Notes.DataStructures.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindAllPossibleStartToEndPaths {
    static void findStartAndEndLocations(String[][] pairs){
        /* Create a graph from give matrix */
        Graph<String> g = new Graph<>(pairs);
        /* Get the adjacency list of the Graph */
        HashMap<String, ArrayList<String>> adj = g.getAdjacencyListMap();
        /* List of unique "from" vertices and "to" vertices */
        Set<String> fromVertices = new HashSet<>();
        Set<String> toVertices = new HashSet<>();
        for(String[] pair : pairs){
            fromVertices.add(pair[0]);
            toVertices.add(pair[1]);
        }
        /* List of start vertices and end vertices */
        ArrayList<String> startVertices = new ArrayList<>();
        ArrayList<String> endVertices = new ArrayList<>();
        for(String s : fromVertices){
            if(!toVertices.contains(s)) startVertices.add(s);
        }
        for(String s : toVertices){
            if(!fromVertices.contains(s)) endVertices.add(s);
        }
        for(String s : startVertices){
            System.out.print(s + ": ");
            for(String d : endVertices){
                if(hasPath(s, d, fromVertices, toVertices, adj))
                    System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    private static boolean hasPath(String source, String destination, Set<String> fromVertices, Set<String> toVertices,
                                   HashMap<String,ArrayList<String>> adj){
        HashMap<String, Boolean> isVisited = new HashMap<>();
        for(String s: fromVertices){
            isVisited.put(s, false);
        }
        for(String s: toVertices){
            isVisited.put(s, false);
        }
        return hasPath(source, destination, isVisited, adj);
    }
    private static boolean hasPath(String source, String destination, HashMap<String, Boolean> isVisited, HashMap<String,
            ArrayList<String>> adj){
        isVisited.put(source, true);
        ArrayList<String> adjacentVertices = adj.get(source);
        if(adjacentVertices != null) {
            for (String s : adjacentVertices) {
                if (!isVisited.get(s)){
                    if(hasPath(s, destination, isVisited, adj)) return true;
                }
            }
        }
        return source.equalsIgnoreCase(destination);
    }
    public static void main(String[] args){
        String[][] pairs = {{"A", "B"},{"A", "C"}, {"B", "K"}, {"C", "K"},
                {"E", "L"}, {"F", "G"}, {"J", "M"}, {"E", "F"},{"G", "H"},{"G", "I"}};

        findStartAndEndLocations(pairs);
    }

}
