package LeetCode.StudyPlan.Algorithm1;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day10_01Matrix {
    Deque<Pair<Integer, Integer>> queue;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        queue = new ArrayDeque<>();
        int[][] dist = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Pair<>(i, j));
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.pop();
            int curR = node.getKey();
            int curC = node.getValue();

            for (int[] dir : dirs) {
                int r = dir[0] + curR;
                int c = dir[1] + curC;
                if (isValid(mat, r, c)) {
                    if (dist[r][c] > mat[curR][curC] + 1) {
                        dist[r][c] = mat[curR][curC] + 1;
                        queue.offer(new Pair<>(r, c));
                    }
                }
            }
        }

        return dist;
    }

    private boolean isValid(int[][] mat, int r, int c) {
        return r >= 0 && c >= 0 && r < mat.length && c < mat[r].length;
    }

}
