package LeetCode.Algorithms.Medium;

import java.util.*;

public class Minesweeper {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    /*
        Runtime: 2 ms, faster than 40.54%
        Memory Usage: 39.6 MB, less than 68.75%
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        }else if(board[click[0]][click[1]] == 'E'){
            bfs_sweep(board, click);
        }
        return board;
    }

    public void bfs_sweep(char[][] board, int[] click){
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        visited[click[0]][click[1]] = true;
        while (!queue.isEmpty()){
            int[] _c = queue.poll();
            int mines = 0;
            for(int[] direction : directions) {
                if(isMine(board, _c[0] + direction[0], _c[1] + direction[1]))
                    mines++;
            }
            if(mines == 0) {
                board[_c[0]][_c[1]] = 'B';
                for(int[] direction : directions) {
                    if(!isValid(board, visited, _c[0] + direction[0], _c[1] + direction[1])) continue;
                    visited[_c[0] + direction[0]][_c[1] + direction[1]] = true;
                    if(board[_c[0] + direction[0]][_c[1] + direction[1]] == 'E')
                        queue.add(new int[] {_c[0] + direction[0], _c[1] + direction[1]});
                }
            }
            else board[_c[0]][_c[1]] =  (char) (mines + '0');

        }
    }

    public boolean isMine(char[][] board, int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'M');
    }

    public boolean isValid(char[][] board, boolean[][] visited, int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col]);
    }

    public static void main(String[] args){
        char[][] mine = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        Minesweeper ms = new Minesweeper();
        ms.updateBoard(mine, new int[]{3, 0});
        for(char[] m : mine) System.out.println(m);
    }
}
