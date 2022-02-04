package CrackingTheCodingInterview.ConceptsAndAlgorithms.SortingAndSearching_10;

import java.util.Arrays;

public class SortedMatrixSearch_9 {

    public int[][] findNumber(int x, int[][] matrix){
        int row = 0;
        int column = matrix.length - 1;
        if(matrix[row][column] == x) return new int[][]{{row, column}};
        while (row < matrix.length && column >= 0){
            if (matrix[row][column] < x) row++;
            else if(matrix[row][column] > x) column--;
            else return new int[][]{{row, column}};
        }
        return new int[][]{{-1, -1}};
    }

    public static void main(String[] args){
        int[][] sortedMatrix = {{1, 2, 3, 4, 5},
                {3, 4, 5, 9, 17},
                {4, 6, 8, 19, 100},
                {8 , 10, 10, 110, 120},
                {19, 15, 16, 170, 180}};
        SortedMatrixSearch_9 sm9 = new SortedMatrixSearch_9();
        int[][] solution = sm9.findNumber(200, sortedMatrix);
        System.out.println(Arrays.toString(solution[0]));
    }
}
