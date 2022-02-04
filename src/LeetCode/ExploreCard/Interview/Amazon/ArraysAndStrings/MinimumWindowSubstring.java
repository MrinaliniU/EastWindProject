package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.*;

/*
    Given a string S and a string T,
    find the minimum window in S which will contain all the characters in T in complexity O(n).

    Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Few questions to ask : -
    - Might T have duplicate characters? : Yes
    - Should we count just the unique characters in T to get the smallest
        substring in S? : NO, so if T was AABBCC the smallest substring is "ADOBECODEBANC".
    - If the answer for above statement was true how will your code change?
 */


public class MinimumWindowSubstring {
    static class Pair {
        Integer key;
        Character value;
        Pair(Integer key, Character value){
            this.key = key;
            this.value = value;
        }
        Integer getKey(){
            return this.key;
        }
        Character getValue(){
            return this.value;
        }
    }
    /*
        Runtime: 11 ms, faster than 62.52%
        Memory Usage: 45.1 MB, less than 5.32%
     */
    public String minWindow(String s, String t){
        if (s.length() == 0 || t.length() == 0) return "";
        /* THE DATA STRUCTURE */
        Map<Character, Integer> chars_in_t_count = new HashMap<>();
        Map<Character, Integer> chars_in_window_count = new HashMap<>();
        List<Pair> filtered_s_pairs = new ArrayList<>();
        int left_window = 0, right_window = 0, currentLengthOfDesiredWindow = 0;
        int[] ans = {-1, 0, 0};
        /* PREPARING THE DATA STRUCTURE */
        for (int i = 0; i < t.length(); i++)
            chars_in_t_count.put(t.charAt(i), chars_in_t_count.getOrDefault(t.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++)
            if (chars_in_t_count.containsKey(s.charAt(i))) filtered_s_pairs.add(new Pair(i, s.charAt(i)));
        /* THE LOGIC */
        while (right_window < filtered_s_pairs.size()) {
            char charAtRightWindow = filtered_s_pairs.get(right_window).getValue();
            chars_in_window_count.put(charAtRightWindow, chars_in_window_count.getOrDefault(charAtRightWindow, 0) + 1);
            if (chars_in_window_count.get(charAtRightWindow).equals(chars_in_t_count.get(charAtRightWindow))) currentLengthOfDesiredWindow++;
            /* SHRINK WINDOW */
            while (currentLengthOfDesiredWindow == chars_in_t_count.size()) {
                /* SAVE SMALLEST WINDOW */
                int end = filtered_s_pairs.get(right_window).getKey();
                int start = filtered_s_pairs.get(left_window).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                /* SHRINK */
                char charAtLeftWindow = filtered_s_pairs.get(left_window).getValue();
                chars_in_window_count.put(charAtLeftWindow, chars_in_window_count.get(charAtLeftWindow) - 1); // drop the char at left window
                if (chars_in_window_count.get(charAtLeftWindow) < chars_in_t_count.get(charAtLeftWindow)) currentLengthOfDesiredWindow--;
                left_window++;
            }
            right_window++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args){
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        String s1 = "ADOBECODEBANC", t1 = "ABC", t2 = "CBBC";
        String s2 = "AAAAAAAA", t3 = "A";
        System.out.println(ms.minWindow(s1, t2));
    }

}
