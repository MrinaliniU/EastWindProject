package LeetCode.Algorithms.Hard;

import java.util.*;

public class NQueens {
    List<List<String>> solution;
    boolean[] track_attack;
    boolean[] track_attack_hills;
    boolean[] track_attack_dales;
    int[] queenPosition;
    int N;
    /*
        Runtime: 3 ms, faster than 76.09%
        Memory Usage: 39 MB, less than 37.84%
     */
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        queenPosition = new int[n];
        solution = new ArrayList<>();
        track_attack = new boolean[n];
        track_attack_hills = new boolean[4 * n - 1];
        track_attack_dales = new boolean[2 * n - 1];
        backTrack(0);
        return solution;
    }

    public void backTrack(int row){
        for(int col = 0; col < N; col++){
            if(!is_under_attack(row, col)){
                place_queen(row, col);
                if(row == N - 1) addSolution();
                else backTrack(row + 1);
                remove_queen(row, col);
            }
        }
    }
    boolean is_under_attack(int row, int col){
        return track_attack[col] || track_attack_hills[row - col + 2 * N] || track_attack_dales[row + col];
    }
    void place_queen(int row, int col){
        queenPosition[row] = col;
        track_attack[col] = true;
        track_attack_hills[row - col + 2 * N] = true;
        track_attack_dales[row + col] = true;
    }
    void addSolution(){
        ArrayList<String> queens = new ArrayList<>();
        for(int row = 0; row < N; row++){
            StringBuilder sb = new StringBuilder();
            int col = queenPosition[row];
            for(int c = 0; c < N; c++){
                if(c == col) sb.append("Q");
                else sb.append(".");
            }
            queens.add(sb.toString());
        }
        solution.add(queens);
    }
    void remove_queen(int row, int col){
        queenPosition[row] = 0;
        track_attack[col] = false;
        track_attack_hills[row - col + 2 * N] = false;
        track_attack_dales[row + col] = false;
    }
    public static void main(String[] args){
        NQueens q = new NQueens();
        List<List<String>> result = q.solveNQueens(4);
        for(List<String> r : result) System.out.println(r);
    }

}
