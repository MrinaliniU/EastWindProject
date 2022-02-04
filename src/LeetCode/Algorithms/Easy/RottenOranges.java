package LeetCode.Algorithms.Easy;

import java.util.*;

public class RottenOranges {

    /* public int orangesRottingNoExtraSpace(int[][] grid) {

    } */


    public static void main(String[] args){
        RottenOranges ro = new RottenOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; // 4
        int[][] grid5 = {{2, 1, 0}, {1, 0, 0}}; // 1
        int[][] grid1 ={{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}; // -1
        int[][] grid2 = {{0, 2}}; // 0
        int[][] grid3 = {{0}}; // 0
        int[][] grid4 = {{0, 1}}; // -1
       // System.out.println("Number of minutes " + ro.orangesRotting(grid5));
    }
}
