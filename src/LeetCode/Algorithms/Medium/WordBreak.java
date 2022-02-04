package LeetCode.Algorithms.Medium;
import java.util.*;
public class WordBreak {
    String s;
    List<String> wordDict;
    /* BackTrack O(n ^ n)*/
    public boolean wordBreak_backTract(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        return backTrack(0);
    }

    public boolean backTrack(int startIndex){
        if(startIndex == s.length()) return true;
        for(int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++){
                if(wordDict.contains(s.substring(startIndex, endIndex))){
                    if(backTrack(endIndex)) return true;
                }
        }
        return false;
    }
    /* O(N ^ 2) FASTER than backtrack
    Runtime: 11 ms, faster than 17.48%, Memory Usage: 39.3 MB, less than 5.08% */

    public boolean wordBreak_DP(String s, List<String> wordDict){
        boolean[] DP = new boolean[s.length() + 1];
        DP[0] = true;
        for(int endIndex = 1; endIndex <= s.length(); endIndex++){
            for(int startIndex = 0; startIndex < endIndex; startIndex++){
                if(wordDict.contains(s.substring(startIndex, endIndex))){
                    if(DP[startIndex]) {
                        DP[endIndex] = true;
                        break;
                    }
                }
            }
        }
        return DP[s.length()];
    }

    public static void main(String[] args){
         // List<String> wordDict = Arrays.asList("leet", "code"); String s = "leetcode"; // true
         // List<String> wordDict = Arrays.asList("apple", "pen"); String s = "applepenapple"; // true
         // List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat"); String s = "catsandog"; // false
        // List<String> wordDict = Arrays.asList("cat", "sa", "sand", "dog"); String s = "catsanddog"; // true
        List<String> wordDict = Arrays.asList("sa", "sand", "dog"); String s = "catsanddog"; // false
        WordBreak wb = new WordBreak();
        System.out.print(wb.wordBreak_DP(s, wordDict));
    }
}
