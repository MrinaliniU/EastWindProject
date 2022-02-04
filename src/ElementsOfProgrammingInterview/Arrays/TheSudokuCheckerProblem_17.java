package ElementsOfProgrammingInterview.Arrays;

import java.util.Arrays;
import java.util.List;

public class TheSudokuCheckerProblem_17 {


    public static boolean isValidSudoku(List<List<Integer>> grid) {
        return !rowsHaveDuplicate(grid) && !colsHaveDuplicates(grid) && !miniSquareHasDuplicate(grid);
    }

    public static boolean miniSquareHasDuplicate(List<List<Integer>> grid) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (hasDuplicates(grid, 3 * i, (3 * i) + 2, 3 * j, (3 * j) + 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rowsHaveDuplicate(List<List<Integer>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            if (hasDuplicates(grid, i, i, 0, grid.get(i).size() - 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean colsHaveDuplicates(List<List<Integer>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            if (hasDuplicates(grid, 0, grid.size() - 1, i, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicates(List<List<Integer>> grid, int startRow, int endRow, int startCol, int endCol) {
        int mask = 1;
        int sol = 0;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                int a = grid.get(i).get(j);
                if (a == 0) continue;
                int temp = mask << a;
                if ((sol & temp) != 0) {
                    return true;
                }
                sol += temp;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0),
                Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0),
                Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0),
                Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3),
                Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1),
                Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6),
                Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0),
                Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5),
                Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9)
        );

        boolean isValid = isValidSudoku(grid);
        if (isValid) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }

    }
}
