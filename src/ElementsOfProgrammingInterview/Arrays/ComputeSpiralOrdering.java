package ElementsOfProgrammingInterview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputeSpiralOrdering {

    boolean[][] visited;
    int[][] direction;

    public List<Integer> spiralOrder(List<List<Integer>> grid, int m, int n) {
        visited = new boolean[m][n];
        int numberElements = m * n;
        direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> spiral = new ArrayList<>();
        int i = 0;
        int j = 0;
        int d = 0;
        int x = 0;
        while (x < numberElements) {
            spiral.add(grid.get(i).get(j));
            visited[i][j] = true;

            int nexti = i + direction[d][0];
            int nextj = j + direction[d][1];

            if (inValid(nexti, nextj, m, n)) {
                d = (d + 1) % 4;
                nexti = i + direction[d][0];
                nextj = j + direction[d][1];
            }

            i = nexti;
            j = nextj;
            x++;
        }
        return spiral;
    }

    public boolean inValid(int i, int j, int m, int n) {
        return i < 0 || j < 0 || i >= m || j >= n || visited[i][j];
    }

    public static void main(String[] args) {

        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(24, 25, 26, 27, 28, 29, 30, 31, 10),
                Arrays.asList(23, 40, 41, 42, 43, 44, 45, 32, 11),
                Arrays.asList(22, 39, 38, 37, 36, 35, 34, 33, 12),
                Arrays.asList(21, 20, 19, 18, 17, 16, 15, 14, 13)
        );

        ComputeSpiralOrdering s = new ComputeSpiralOrdering();
        System.out.print(s.spiralOrder(grid, 5, 9));

    }
}
