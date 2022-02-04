package LeetCode.Algorithms.Medium;

public class FriendCircles {
    /*
        My initial approach was to prepare an adjacency list and then perform
        DFS on that. Building an adjacency list from a matrix takes O(n^2) time.
        DFS itself is O(N^2) so technically we are not increasing the runtime
        but we can reduce the number of operation by following the below code.
     */
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 40.4 MB, less than 60.00%
     */
    boolean[] visited;
    public int findCircleNum(int[][] M) {
        int circles = 0;
        visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(!visited[i]) {
                circles++;
                dfs(M, i);
            }
        }
        return circles;
    }
    /*
        See how the dfs below is similar in structure when you use dfs with
        adjacency matrix.
     public void dfs(int person){
        if(visited[person]) return;
        visited[person] = true;
        for(int neighbor : graph.getOrDefault(person, new HashSet<>())){
            dfs(neighbor);
        }
    }
     */
    public void dfs(int[][] M, int person1){
        if(visited[person1]) return;
        visited[person1] = true;
        for(int person2 = 0; person2 < M.length; person2++){
            if(M[person1][person2] == 1) dfs(M, person2);
        }
    }
    public static void main(String[] args){
        FriendCircles fc = new FriendCircles();
        int[][] M = {{1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        System.out.println(fc.findCircleNum(M));
    }
}
