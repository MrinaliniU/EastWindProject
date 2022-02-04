package LeetCode.Algorithms.Medium;
/*
    Not my code but written so well in discussion board of leetcode. Love this code.
    Runtime: 3 ms, faster than 100.00%, Memory Usage: 42.3 MB, less than 100.00%
 */
public class DesignTicTacToe {
    Player[] players;
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        players = new Player[]{new Player(n), new Player(n)};
    }

    public int move(int row, int col, int player) {
        /* Move is guaranteed to be valid and is placed on an empty block. */
        if(this.players[player - 1].moveAndCheckWin(row, col)) return player;
        return 0;
    }

    static class Player{
        int[] row, col;
        int dale, hill;
        int N;
        Player(int n){
            N = n;
            row = new int[n];
            col = new int[n];
            dale = 0;
            hill = 0;
        }

        public boolean moveAndCheckWin(int row, int col){
            this.row[row]++;
            this.col[col]++;
            if(row == col) hill++;
            if(row + col == N - 1) dale++;
            return this.row[row] == N || this.col[col] == N || dale == N || hill == N;
        }
    }
}
