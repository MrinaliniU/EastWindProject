package LeetCode.Algorithms.Medium;
/* Back Tracking Problem */
/*
    Runtime: 9 ms, faster than 28.54%
    Memory Usage: 40.8 MB, less than 36.74%
 */
public class WordSearch {
    public boolean exist(char[][] matrix, String word) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(backtrack(i, j, matrix, 0, word)) return true;
            }
        }
        return false;
    }
    public boolean backtrack(int row, int col, char[][] matrix, int index, String word){
        if(index >= word.length()) return true; // all chars are compared.
        if(!isValid(row, col, matrix, index, word)) return false;
        matrix[row][col] = '#';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // four direction;
        boolean result = false;
        for(int[] direction : directions){
            result = backtrack(row + direction[0], col + direction[1], matrix, index + 1, word);
            if(result) break;
        }
        // un-mark
        matrix[row][col] = word.charAt(index);
        return result;
    }

    public boolean isValid(int row, int col, char[][] matrix, int index, String word){
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == word.charAt(index));
    }

    public static void main(String[] args){
        char[][] matrix = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(matrix, "ABCCED"));
    }
}
