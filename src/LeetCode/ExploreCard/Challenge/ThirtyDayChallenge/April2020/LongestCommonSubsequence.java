package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] DP = new int[text1.length()][text2.length()];
        for(int i = 0; i < DP.length; i++){
            for(int j = 0; j < DP[0].length; j++){
                if(i - 1 >= 0 && j - 1 >= 0){
                    if(text1.charAt(i) == text2.charAt(j)) DP[i][j] = DP[i - 1][j - 1] + 1;
                    else DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        return DP[text1.length() - 1][text2.length() - 1];
    }
}
