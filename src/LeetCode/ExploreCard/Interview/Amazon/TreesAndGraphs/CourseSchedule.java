package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
import java.util.*;
public class CourseSchedule {
    /*
        I initially used black/grey as List<Integer> using them as boolean[] brought down runtime
        from 45ms to 3. checking if grey/black contains a node using List.contains() increases
        runtime significantly compared to just checking boolean array at index node to be true/false.
        Runtime: 3 ms
        Memory Usage: 40.3 MB
     */
    int[] color; // (0, 1, 2)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = getGraph(numCourses, prerequisites);
        color = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(color[i] == 0) if(hasCycle(graph, i)) return false;
        }
        return true;
    }

    public boolean hasCycle(HashMap<Integer, List<Integer>> graph, int course){
        if(color[course] == 2 || !graph.containsKey(course)) return false; // no cycle
        if(color[course] == 1) return true; // has cycle
        color[course] = 1;// color it grey
        boolean detect_cycle = false;
        for(Integer neighbor : graph.get(course)){
            detect_cycle = hasCycle(graph, neighbor);
            if(detect_cycle) break;
        }
        color[course] = 2;
        return detect_cycle;
    }

    public HashMap<Integer, List<Integer>> getGraph(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }
    /* Not my code */
      /* Runtime: 3 ms
      Memory Usage: 39.5 MB */
    public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] preCount = new int[numCourses];
        for(int i = 0; i<graph.length;i++)graph[i] = new ArrayList<Integer>();
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            preCount[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<preCount.length;i++){
            if(preCount[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int n : graph[node]){
                preCount[n]--;
                if(preCount[n]==0)q.offer(n);
            }
        }
        for(int num : preCount)if(num>0)return false;
        return true;
    }

    public static void main(String[] args){
        CourseSchedule cs = new CourseSchedule();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses3 = 4;
        int[][] prerequisites3 = {{3, 0}, {0, 1}};
        System.out.println("Can finish all courses " + cs.canFinish(numCourses1, prerequisites1)); // true
        System.out.println("Can finish all courses " + cs.canFinish(numCourses2, prerequisites2)); // false
        System.out.println("Can finish all courses " + cs.canFinish(numCourses3, prerequisites3)); // true
    }
}
