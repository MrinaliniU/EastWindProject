package LeetCode.Algorithms.Easy;

public class IslandPerimeter {
    // Runtime: 14 ms, faster than 9.75%
        public int islandPerimeter(int[][] grid) {
            int perimeter_count = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1){
                        if(i == 0 || grid[i - 1][j] == 0) perimeter_count++;
                        if(i == grid.length - 1 || grid[i + 1][j] == 0) perimeter_count++;
                        if(j == 0 || grid[i][j - 1] == 0) perimeter_count++;
                        if(j == grid[i].length - 1 || grid[i][j + 1] == 0) perimeter_count++;
                    }
                }
            }
            return perimeter_count;
        }
}
