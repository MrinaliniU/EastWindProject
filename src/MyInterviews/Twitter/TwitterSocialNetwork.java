package MyInterviews.Twitter;

import java.util.*;

public class TwitterSocialNetwork {

    public static int depthFirstSearch(int numberOfNodes, List<LinkedList<Integer>> al){
        int count = 0;
        boolean[] visited = new boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes ; i++) {
            if(!visited[i]){
                depthFirstSearch(i, visited, al);
                count++;
            }
        }
        return count;
    }
    public static void depthFirstSearch(int start, boolean[] visited, List<LinkedList<Integer>> al){
        visited[start] = true;
        for (int i = 0; i < al.get(start).size() ; i++) {
            int vertex = al.get(start).get(i);
            if(!visited[vertex]){
                depthFirstSearch(vertex,visited, al);
            }
        }
    }
    public static int countGroups(List<String> related){
        int numberOfNodes = related.size();
        List<LinkedList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < numberOfNodes; i++){
            al.add(new LinkedList<>());
        }
        for(int j = 0; j < numberOfNodes; j++){
            for(int i = 0; i < related.get(0).length(); i++){
                if(related.get(j).charAt(i) =='1'){
                    al.get(i).addFirst(j);
                }
            }
        }
        return depthFirstSearch(numberOfNodes, al);
    }

    public static void main(String[] args){
        List<String> related = new ArrayList<>(Arrays.asList("1100", "1110","0110", "0001"));
        //List<String> related = new ArrayList<String>(Arrays.asList("110", "110", "001"));
        //List<String> related = new ArrayList<String>(Arrays.asList("1100", "1110", "0110", "0001"));
        //List<String> related = new ArrayList<String>(Arrays.asList("11000", "01001", "10011", "00000", "10110"));
        //List<String> related = new ArrayList<String>(Arrays.asList("10000", "01000", "00100", "00010", "00001"));
        //List<String> related = new ArrayList<String>(Arrays.asList("0001100", "0100110", "1101001", "0000010", "1100000", "0001000"));
        System.out.println("Number of islands " + countGroups(related));
    }
}
