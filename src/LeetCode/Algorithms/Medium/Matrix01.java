package LeetCode.Algorithms.Medium;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[m - 1].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                updateByLeftAndUp(i, j, mat);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                updateByRightAndDown(i, j, m, n, mat);
            }
        }
        return mat;
    }

    private void updateByLeftAndUp(int i, int j, int[][] mat) {
        if (j - 1 >= 0 && mat[i][j - 1] != Integer.MAX_VALUE) {
            mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
        }

        if (i - 1 >= 0 && mat[i - 1][j] != Integer.MAX_VALUE) {
            mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
        }
    }

    private void updateByRightAndDown(int i, int j, int m, int n, int[][] mat) {
        if (j + 1 < n && mat[i][j + 1] != Integer.MAX_VALUE) {
            mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
        }

        if (i + 1 < m && mat[i + 1][j] != Integer.MAX_VALUE) {
            mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
        }
    }

    public static void main(String[] args){
        // int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        Matrix01 m = new Matrix01();
        int[][] mat = {
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        };
        m.updateMatrix(mat);
    }
}
