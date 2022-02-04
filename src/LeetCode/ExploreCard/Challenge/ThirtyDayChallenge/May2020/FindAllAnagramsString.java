package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;


import java.util.*;

public class FindAllAnagramsString {
    /*
        Runtime: 17 ms
        Memory Usage: 44.8 MB
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> listOfAnagramIndices = new ArrayList<>();
        /* update p count */
        for(char c : p.toCharArray()) pCount[c - 'a']++;
        /* Walk through s */
        for(int i = 0; i < sLen; i++){
            sCount[s.charAt(i) - 'a']++;
            if(i >= pLen) sCount[s.charAt(i - pLen) - 'a']--;
            if(Arrays.equals(sCount, pCount))  listOfAnagramIndices.add(i - pLen + 1);
        }
        return listOfAnagramIndices;
    }
    /* found in discussion. */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();
        // fill in p values
        for(int i = 0; i < p.length(); i++) map[p.charAt(i) - 'a']++;
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd<s.length()){
            // valid anagram
            if(map[s.charAt(windowEnd) - 'a'] > 0){
                map[s.charAt(windowEnd++) - 'a']--;
                if(windowEnd-windowStart ==  p.length()){ // window size equal to size of P
                    result.add(windowStart);
                }
            }
            else if(windowStart == windowEnd){ // window is of size 0
                windowStart ++;
                windowEnd ++;
            }
            else{ // decrease window size
                map[s.charAt(windowStart++) - 'a']++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        FindAllAnagramsString fa = new FindAllAnagramsString();
         String s = "cbaebabacd", p = "abc"; System.out.println(fa.findAnagrams(s, p));
        //String s = "abab", p = "ab"; System.out.println(fa.findAnagrams(s, p));
    }
}
