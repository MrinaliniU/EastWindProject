package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.*;

/*
    Problem No. 200.
 */
public class NumberOfIslands {

    public int numberOfIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited[i][j]){
                    numberOfIslands += bfs(visited, grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }
    /*
        Runtime: 3 ms, faster than 27.44%
        Memory Usage: 43.1 MB, less than 5.12%
     */
    public int bfs(boolean[][] visited, char[][] grid, int i, int j){
        if(grid[i][j] != '1') return 0;
        else {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j});
            while(!queue.isEmpty()){
                int[] p = queue.poll();
                visitAndAddNeighbours(p, queue, grid, visited);
            }
            return 1;
        }
    }

    public void visitAndAddNeighbours(int[] p, Queue<int[]> queue, char[][] grid, boolean[][] visited){
        visited[p[0]][p[1]] = true;
        if(p[0] - 1 >= 0 && grid[p[0] - 1][p[1]] == '1' && !visited[p[0] - 1][p[1]])
        {
            queue.add(new int[]{p[0] - 1, p[1]}); //top
            visited[p[0] - 1][p[1]] = true;
        }
        if(p[0] + 1 < grid.length && grid[p[0] + 1][p[1]] == '1' && !visited[p[0] + 1][p[1]])
        {
            queue.add(new int[]{p[0] + 1, p[1]}); // bottom
            visited[p[0] + 1][p[1]] = true;
        }
        if(p[1] - 1 >= 0 && grid[p[0]][p[1] - 1] == '1' && !visited[p[0]][p[1] - 1])
        {
            queue.add(new int[]{p[0], p[1] - 1}); //left
            visited[p[0]][p[1] - 1] = true;
        }
        if(p[1] + 1 < grid[p[0]].length && grid[p[0]][p[1] + 1] == '1' && !visited[p[0]][p[1] + 1])
        {
            queue.add(new int[]{p[0], p[1] + 1}); //right
            visited[p[0]][p[1] + 1] = true;
        }
    }

    public static void main(String[] args){
        NumberOfIslands ni = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'} };

        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '1', '0', '0'},
                          {'0', '0', '0', '1', '0'} };
        char[][] grid3 = {};
        char[][] grid4 = {{'0', '0'},
                {'1', '0'},
                {'0'},
                {'1', '0'}};
        char[][] grid5 = {{'1'}, {'1'}};

        System.out.println("Number of islands " + ni.numberOfIslands(grid5));
    }
}
