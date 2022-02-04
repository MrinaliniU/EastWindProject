package LeetCode.Algorithms.Medium;
/*
    Problem No. 5.
 */
public class LongestPalindromicSubString {

    // TODO: 3/6/2020 #MyInterviews.Microsoft #String #DynamicPrograming
    /* The logic of finding a palindrome is simple. This logic is for finding continuous palindrome An odd length
    * palindrome will look different from an even length palindrome. "aba" and "abba" an even length palindrome has two
    * chars in the middle of the string that are same but for an odd palindrome the middle char mirrors the chars on
    * its left to it's right.
    * So it is important to check for a possibility of having both an even or an odd palindrome.
    * We check every char to be the middle of a palindrome by expanding the window size around this char and checking
    * how far the window expands forming a palindrome. We also do this for a possibility of having an even palindrome
    * by checking char at i and i + 1 to be same and expanding around these two chars and checking how long the window
    * grows forming a palindrome. We can check this for string length 0 to string length and return the index of the
    * of the longest substring. */
    /* Runtime: 23 ms, faster than 72.41%
    * Memory Usage: 38 MB, less than 50.40% */
    public String longestPalindrome(String s){
        if (s == null || s.length() < 1) return "";
        int lenOfLongestPalindrome = 0;
        int start = 0; int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expand(s, i, i); // for odd length palindrome
            int len2 = expand(s, i, i + 1); // for even length palindrome
            int len = Math.max(len1, len2);
            lenOfLongestPalindrome = Math.max(lenOfLongestPalindrome, len); // return this if you need just length.
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int L, int R){
        int l = L; int r = R;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

    /* This logic is to find the longest palindrome in a given string but is not necessarily a continuous substring
    * O(n^2) space and run time complexity */
    public int longestDiscontinuousPalindrome(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            memo[i][i] = 1;
        }
        for(int len = 1; len < s.length(); len++){
            for(int i = 0; i + len < s.length(); i++){
                if(s.charAt(i) == s.charAt(i + len))
                    memo[i][i + len] = memo[i + 1][i + len - 1] + 2;
                else
                    memo[i][i + len] = Math.max(memo[i][i + len - 1], memo[i + 1][i + len]);
            }
        }
        return memo[0][memo[0].length - 1];
    }

    public static void main(String[] args){
        String s = "babad";
        String s2 = "cbbd";
        String s3 = "abacdgfdcaba";
        String s4 = "abacdggdcaba";
        String s5 = "agbdba";
        String s6 = "agbxyba";
        String s7 = "agbxyab";
        LongestPalindromicSubString lp = new LongestPalindromicSubString();
        /*System.out.println(lp.longestPalindrome(s));
        System.out.println(lp.longestPalindrome(s2));
        System.out.println(lp.longestPalindrome(s3));
        System.out.println(lp.longestPalindrome(s4));*/
        // System.out.println(lp.longestDiscontinuousPalindrome(s6));
        System.out.println(lp.longestPalindrome(s));

    }
}
