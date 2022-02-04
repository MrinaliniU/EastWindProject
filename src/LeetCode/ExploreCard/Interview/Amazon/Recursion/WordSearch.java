package LeetCode.ExploreCard.Interview.Amazon.Recursion;

public class WordSearch {
    char[][] matrix;
    String word;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] matrix, String word) {
        this.matrix = matrix;
        this.word = word;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(backTrack(0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean backTrack(int index, int row, int col){
        if(index >= word.length()) return true; // all chars are checked.
        if(!isValid(index, row, col)) return false;
        matrix[row][col] = '#';
        boolean result = false;
        for(int[] direction : directions){
            result = backTrack(index + 1, row + direction[0] , col + direction[1]);
            if(result) break; // break because you don't want to go searching in other un-explored direction
        }
        matrix[row][col] = word.charAt(index);
        return result;
    }

    public boolean isValid(int index, int row, int col){
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == word.charAt(index));
    }

    public static void main(String[] args){
        String word = "ABFC";
        char[][] matrix = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        WordSearch w = new WordSearch();
       System.out.print(w.exist(matrix, word));
    }
}
