package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix_8 {

    public void zeroMatrixBetterSpaceComplexity(ArrayList<ArrayList<Integer>> matrix){
        boolean rowZeros = false;
        boolean columnZeros = false;
        /* Check if first row has zero */
        for(int i = 0; i < matrix.get(0).size(); i++){
            if(matrix.get(0).get(i) == 0){
                rowZeros = true;
                break;
            }
        }
        /* Check if first column has zero */
        for(int i = 0; i < matrix.size(); i++){
            if(matrix.get(i).get(0) == 0){
                columnZeros = true;
                break;
            }
        }
        /* Check for the rest of the matrix for zeros, if zero is found make the element is same index of first row and
            first column as zero. */

        for(int i = 1; i < matrix.size(); i++){
            for(int j = 1; j < matrix.get(0).size(); j++){
                if(matrix.get(i).get(j) == 0){
                    matrix.get(0).set(j, 0);
                    matrix.get(i).set(0, 0);
                }
            }
        }
        /* Nullify rows based on first "column" */
        for(int i = 1; i < matrix.size(); i++){
            if(matrix.get(i).get(0) == 0){
                nullifyRow(matrix, i);
            }
        }
        /* Nullify columns based on first "row" */
        for(int i = 1; i < matrix.get(0).size(); i++){
            if(matrix.get(0).get(i) == 0){
                nullifyColumn(matrix, i);
            }
        }
        /* if first row had zero make that row zero */
        if(rowZeros)
            nullifyRow(matrix, 0);
        /* if first column had zero make that column zero */
        if(columnZeros)
            nullifyColumn(matrix, 0);
    }

    public void zeroMatrix(ArrayList<ArrayList<Integer>> matrix){
        int[] rowZeros = new int[matrix.size()];
        int[] columnZeros = new int[matrix.get(0).size()];
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(0).size(); j++){
                if(matrix.get(i).get(j) == 0){
                    rowZeros[i] = 1;
                    columnZeros[j] = 1;
                }
            }
        }
        for(int i = 0; i < rowZeros.length; i++){
            if(rowZeros[i] == 1){
                nullifyRow(matrix, i);
            }
        }

        for(int i = 0; i < columnZeros.length; i++){
            if(columnZeros[i] == 1){
                nullifyColumn(matrix, i);
            }
        }
    }

    private void nullifyRow(ArrayList<ArrayList<Integer>> matrix, int row){
        for(int i = 0; i < matrix.get(row).size(); i++){
            matrix.get(row).set(i, 0);
        }
    }
    private void nullifyColumn(ArrayList<ArrayList<Integer>> matrix, int column){
        for (ArrayList<Integer> integers : matrix) {
            integers.set(column, 0);
        }
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(1, 1, 0, 1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(1, 0, 1, 1));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        matrix.add(one);
        matrix.add(two);
        matrix.add(three);
        ZeroMatrix_8 zeroMatrix_8 = new ZeroMatrix_8();
        zeroMatrix_8.zeroMatrix(matrix);
        //zeroMatrix_8.zeroMatrixBetterSpaceComplexity(matrix);
        zeroMatrix_8.printMatrix(matrix);
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> matrix){
        for(ArrayList<Integer> i : matrix){
            for(int x : i){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
