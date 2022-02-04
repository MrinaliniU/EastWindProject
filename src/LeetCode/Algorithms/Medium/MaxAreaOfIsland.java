package LeetCode.Algorithms.Medium;

public class MaxAreaOfIsland {
    /*
        Runtime: 3 ms, faster than 45.82%
        Memory Usage: 40.1 MB, less than 96.30%
     */
    int max;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //int temp_area;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    //temp_area = 0;
                    max = Math.max(max, dfs(grid, i, j));
                   // max = Math.max(temp_area, max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col){
        if(!isValid(grid, row, col)) return 0;
        grid[row][col] = 0;
        //temp_area++;
        int area = 1;
        for(int[] direction : directions){
             area += dfs(grid, row + direction[0], col + direction[1]);
        }
        return area;
    }

    public boolean isValid(int[][] grid, int row, int col){
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1);
    }

    public static void main(String[] args){
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int area = ma.maxAreaOfIsland(grid);
        System.out.println(area);
    }
}
