package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

public class MaximalSquare {
    /*
        Runtime: 4 ms, faster than 85.04%
        Memory Usage: 42.4 MB, less than 100.00%
     */
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0, row = matrix.length, col = row > 0 ? matrix[0].length : 0;
        int[][] DP = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    DP[i][j] = Math.min(Math.min(DP[i][j - 1], DP[i - 1][j - 1]), DP[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, DP[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
