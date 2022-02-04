package LeetCode.StudyPlan.Algorithm1;

import LeetCode.Algorithms.Medium.MaxAreaOfIsland;

public class Day7_MaxAreaOfAnIsland {
    boolean[][] visited;
    int maxLen;

    public int maxAreaOfIsland(int[][] grid) {
        maxLen = 0;
        int gridLen = grid.length;
        visited = new boolean[gridLen][grid[gridLen - 1].length];
        for (int i = 0; i < gridLen; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int len = dfs(grid, i, j, 0);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    private int dfs(int[][] grid, int r, int c, int len) {
        if (!isValid(grid, r, c)) {
            return 0;
        }
        visited[r][c] = true;
        int up = dfs(grid, r - 1, c, len);
        int down = dfs(grid, r + 1, c, len);
        int left = dfs(grid, r, c - 1, len);
        int right = dfs(grid, r, c + 1, len);
        return up + down + left + right + 1;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && !visited[r][c] && grid[r][c] == 1;
    }

    public static void main(String[] args) {
        Day7_MaxAreaOfAnIsland maxAreaOfAnIsland = new Day7_MaxAreaOfAnIsland();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int result = maxAreaOfAnIsland.maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
