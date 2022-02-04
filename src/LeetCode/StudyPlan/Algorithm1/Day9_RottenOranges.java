package LeetCode.StudyPlan.Algorithm1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day9_RottenOranges {
    boolean[][] visited;
    int orangesCount;
    Deque<int[]> rottenQueue;
    int minutes;
    public int orangesRotting(int[][] grid) {
        rottenQueue = new ArrayDeque<>();
        visited = new boolean[grid.length][grid[0].length];
        setUp(grid);

        while (!rottenQueue.isEmpty()) {
            int[] p = rottenQueue.pop();
            if (rottenQueue.isEmpty() || rottenQueue.peek()[2] != p[2]) {
                if (p[2] != 0) minutes++;
            }
            rotOranges(grid, p[0] + 1, p[1], p[2]);
            rotOranges(grid, p[0] - 1, p[1], p[2]);
            rotOranges(grid, p[0], p[1] + 1, p[2]);
            rotOranges(grid, p[0], p[1] - 1, p[2]);
        }

        return orangesCount == 0 ? minutes : -1;
    }

    private void rotOranges(int[][] grid, int r, int c, int depth) {
        if (valid(grid, r, c)) {
            rottenQueue.add(new int[]{r, c, depth + 1});
            visited[r][c] = true;
            orangesCount--;
        }
    }

    private void setUp(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    orangesCount++;
                }
                if (grid[i][j] == 2) {
                    rottenQueue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
    }

    private boolean valid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && !visited[r][c] && grid[r][c] == 1;
    }


    public static void main(String[] args) {
        Day9_RottenOranges d9 = new Day9_RottenOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        d9.orangesRotting(grid);
    }
}
