package ElementsOfProgrammingInterview.Arrays.variants;

import java.util.Arrays;
import java.util.List;

public class GetKthElementInArrayRepresentedByMatrix {

    public static Integer getKthElement(List<List<Integer>> grid, int k) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        if ((k > rows * cols) || k < 1) return -1;
        int rowDiv = (k / rows);
        int colMod = (k % cols);
        int row = k % rows == 0 ? rowDiv - 1 : rowDiv;
        int col = colMod == 0 ? cols - 1 : colMod - 1;
        return grid.get(row).get(col);
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18),
                Arrays.asList(19, 20, 21, 22, 23, 24, 25, 26, 27),
                Arrays.asList(28, 29, 30, 31, 32, 33, 34, 35, 36),
                Arrays.asList(37, 38, 39, 40, 41, 42, 43, 44, 45),
                Arrays.asList(46, 47, 48, 49, 50, 51, 52, 53, 54),
                Arrays.asList(55, 56, 57, 58, 59, 60, 61, 62, 63),
                Arrays.asList(64, 65, 66, 67, 68, 69, 70, 71, 72),
                Arrays.asList(73, 74, 75, 76, 77, 78, 79, 80, 81)
        );

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(10, 11, 13)
        );

        for (int i = 1; i < 14; i++) {
            System.out.print(getKthElement(grid2, i) + ", ");
        }

        int n = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("(" + (n / 4) + ", " + (n % 3) + ") ");
                n++;
            }
            System.out.println();
        }
    }
}
