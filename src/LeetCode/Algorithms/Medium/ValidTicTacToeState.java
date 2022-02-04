package LeetCode.Algorithms.Medium;
/* Runtime: 1 ms, faster than 15.25%
* Memory Usage: 38.7 MB, less than 7.14% */
public class ValidTicTacToeState {
    static class Player{
        int[] row, col;
        int dale, hill, N;
        Player(int n){
            this.row = new int[n];
            this.col = new int[n];
            this.dale = 0;
            this.hill = 0;
            this.N = n;
        }
        boolean playerWon(int row, int col){
            this.row[row]++;
            this.col[col]++;
            if(row == col) this.hill++;
            if(row + col == N - 1) this.dale++;
            return this.row[row] == N || this.col[col] == N || this.dale == N || this.hill == N;
        }
        void resetPlayer(){
            this.row = new int[N];
            this.col = new int[N];
            this.dale = 0;
            this.hill = 0;
        }
    }
    public boolean validTicTacToe(String[] board) {
        int N = board.length;
        Player playerX = new Player(N);
        Player playerY = new Player(N);
        int numOfX = 0, numOfY = 0;
        char winner = '#';
          for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i].charAt(j) == 'X'){
                    numOfX++;
                    if(playerX.playerWon(i, j)) {
                        if(winner == 'Y') return false;
                        winner = 'X';
                        playerX.resetPlayer();
                    }
                }else if(board[i].charAt(j) == 'O'){
                    numOfY++;
                    if(playerY.playerWon(i, j)) {
                        if(winner == 'X') return false;
                        winner = 'Y';
                        playerY.resetPlayer();
                    }
                }
            }
        }
        if(numOfX != numOfY && numOfY != numOfX - 1) return false;
        if(winner == 'X' && numOfY != numOfX - 1) return false;
        if(winner == 'Y' && numOfX != numOfY) return false;
        return true;
    }

    public static void main(String[] args){
         String[] board = {"XOX","O O","XOX"}; // true
        // String[] board = {"XOX"," X ","   "}; // false
        //String[] board = {"XXX","OOX","OOX"}; // true
        //String[] board = {"XXX","XOO","OO "}; // false
        ValidTicTacToeState v = new ValidTicTacToeState();
        System.out.print(v.validTicTacToe(board));
    }
}
