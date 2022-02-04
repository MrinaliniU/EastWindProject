package LeetCode.Algorithms.Medium;

import java.util.*;

public class CourseSchedule2 {
    int numCourses; int[][] prerequisites;
    HashMap<Integer, List<Integer>> graph;
    int[] result;
    int[] color; // 0 not visited; 1 visited
    Stack<Integer> course_order;
    /*
        Runtime: 4 ms, faster than 83.28%
        Memory Usage: 41.1 MB, less than 97.56%
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        color = new int[numCourses];
        graph = getGraph();
        course_order = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if (color[i] == 0) if(hasCycle(i)) return new int[0];
        }

        result = new int[course_order.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = course_order.pop();
        }
        return result;
    }

    public boolean hasCycle(int course){
        if(color[course] == 2) return false;
        if(color[course] == 1) return true;
        color[course] = 1; // color it grey
        boolean detect_cycle = false;
        for(int neighbor : graph.getOrDefault(course, new ArrayList<>())){
            detect_cycle = hasCycle(neighbor);
            if(detect_cycle) break;
        }
        color[course] = 2;
        course_order.add(course);
        return detect_cycle;
    }

    public HashMap<Integer, List<Integer>> getGraph(){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }

    public static void main(String[] args){
        CourseSchedule2 c2 = new CourseSchedule2();
        //int[][] pre = {{1,0},{2,0},{3,1},{3,2}}; int n = 4;
        //int[][] pre = {{0, 1}, {1, 0}}; int n = 2;
        int[][] pre = {{2, 1}, {3, 1}, {4, 2}, {4, 3}, {0, 5}, {5, 0}}; int n = 6;
        int[] result = c2.findOrder(n, pre);
        System.out.println(Arrays.toString(result));
    }
}
