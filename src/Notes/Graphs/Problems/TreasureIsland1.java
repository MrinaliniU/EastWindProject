package Notes.Graphs.Problems;

import java.util.ArrayList;
import java.util.List;

public class TreasureIsland1 {

/*    public int toTheNearestTreasureIsland(char[][] grid){
        List<int[]> allTreasureIslands = allTreasureIsland(grid);
        for(int[] treasureIsland : allTreasureIslands){

        }
    }

    public int shortestDistanceFromOrigin(int[] islandLocation, char[][] grid){
        int[] position = {0, 0};
        int dist = Integer.MAX_VALUE;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] direction : directions){
            int r = position[0] + direction[0];
            int c = position[1] + direction[1];
            if(isSafe(grid, r, c) && manhattanDistance(islandLocation, new int[]{r, c}) < dist)
                position = new int[]{r, c};
        }
    }*/
    public boolean isSafe(char[][] grid, int r, int c){
        return (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D');
    }
    public int manhattanDistance(int[] x, int[] y){
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public List<int[]> allTreasureIsland(char[][] grid){
        List<int[]> treasureIslands = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'X') treasureIslands.add(new int[]{i, j});
            }
        }
        return treasureIslands;
    }

    public static void main(String[] args){

    }
}
