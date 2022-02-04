package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

public class NumberOfIslands {
    int numberOfIslands;
    char[][] _grid;
    /*
        Runtime: 1 ms
        Memory Usage: 42.5 MB
     */
    public int numIslands(char[][] grid) {
        return helper(grid);
    }
    public int helper(char[][] grid){
        numberOfIslands = 0;
        _grid = grid; // this is just a pointer not a copy of the grid
        for(int i = 0; i < _grid.length; i++){
            for(int j = 0; j < _grid[0].length; j++){
                if(_grid[i][j] != '0'){
                    dfs(i, j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }
    public void dfs(int row, int col){
        if(!isValid(row, col)) return;
        _grid[row][col] = '0'; // visit the location;
        dfs(row, col - 1);
        dfs(row, col + 1);
        dfs(row - 1, col);
        dfs(row + 1, col);
    }
    public boolean isValid(int row, int col){
        return (row >= 0 && row < _grid.length && col >= 0 && col < _grid[0].length && _grid[row][col] == '1');
    }

    public static void main(String[] args){
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("Number of Islands " + n.numIslands(grid));
        System.out.println("Number of Islands " + n.numIslands(grid2));
    }
}
