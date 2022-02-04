package LeetCode.Algorithms.Hard;

public class NQueen2 {
    /*
        Runtime: 1 ms, faster than 82.31%
        Memory Usage: 36.2 MB, less than 8.70%
     */
    int N;
    boolean[] track_attack;
    boolean[] track_attack_hill;
    boolean[] track_attack_dale;
    int count;
    public int totalNQueens(int n) {
        this.N = n;
        this.track_attack = new boolean[n];
        this.track_attack_hill = new boolean[4 * n - 1];
        this.track_attack_dale = new boolean[2 * n - 1];
        this.count = 0;
        backTrack(0);
        return count;
    }

    public void backTrack(int row){
        for(int col = 0; col < N; col++){
            if(!is_under_attack(row, col)){
                placeQueen(row, col);
                if(row == N - 1) count++; // you are in the last row
                else backTrack(row + 1);
                remove_queen(row, col);
            }
        }
    }

    boolean is_under_attack(int row, int col){
        return track_attack[col] || track_attack_hill[row - col + 2 * N] || track_attack_dale[row + col];
    }

    void placeQueen(int row, int col){
        track_attack[col] = true;
        track_attack_hill[row - col + 2 * N] = true;
        track_attack_dale[row + col] = true;
    }
    void remove_queen(int row, int col){
        track_attack[col] = false;
        track_attack_hill[row - col + 2 * N] = false;
        track_attack_dale[row + col] = false;
    }
    public static void main(String[] args){
        NQueen2 nq = new NQueen2();
        System.out.println(nq.totalNQueens(4));
    }
}
