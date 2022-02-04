package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.Arrays;

/*
    This problem can be solved by Brute Force Approach or by Dynamic Programming.
    Brute Fore involves recursively finding the sum of current location + Math.min(Down, Right).
    When you recursively reach the start point you would have the solution.
    DP can be solved by varying degree of space complexity.
        - Use extra R * C matrix, R = number of rows in original matrix
            C = number of column in original matrix, to calculate sum from bottom right to top left.
        - Use 1D array of size R calculate sum from right to left for each cell and move upwards
        - Instead of using additional matrix simply modify the given grid with sum and return the
            final value you get at top left cell (0, 0).
 */
public class MinimumPathSum {
    /*
        Runtime: 8 ms
        Memory Usage: 43 MB
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[grid.length - 1].length - 1;
        for(int i = row; i >= 0; i--){
            for(int j = col; j >= 0; j--){
                if(i == row && j == col) continue;
                grid[i][j] += Math.min(getVal(i, j + 1, grid), getVal(i + 1, j, grid));
            }
        }
        return grid[0][0];
    }
    public int getVal(int row, int col, int[][] grid){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) return grid[row][col];
        else return Integer.MAX_VALUE;
    }
    public int minPathSum_dp2(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[] memo = new int[col + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        for(int i = row; i >= 0; i--){
            for(int j = col; j >=0; j--){
                if(i == row && j == col) memo[j] = grid[i][j];
                else {
                    int _j = j + 1 > col ? Integer.MAX_VALUE : memo[j + 1];
                    memo[j] = grid[i][j] + Math.min(memo[j], _j);
                }
            }
        }
        return memo[0];
    }
    public int minPathSum_bruteForce(int[][] grid) {
        return helper(grid, 0, 0);
    }
    public int helper(int[][] grid, int row, int col){
        if(row == grid.length - 1 && col == grid[row].length - 1) return grid[row][col];
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0) return Integer.MAX_VALUE;
        int bottom = helper(grid, row + 1, col);
        int right  = helper(grid, row, col + 1);
        return grid[row][col] + Math.min(right, bottom);
    }

    public static void main(String[] args){
        MinimumPathSum mp = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mp.minPathSum(grid));
    }
}
