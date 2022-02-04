package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.Arrays;

public class PermutationInString {
    /*
    Runtime: 3 ms
    Memory Usage: 39.3 MB
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int len1 = s1.length(), len2 = s2.length();
        for(char c : s1.toCharArray()) s1Count[c - 'a']++;
        for(int i = 0; i < len2; i++){
            s2Count[s2.charAt(i) - 'a']++;
            if(i >= len1 - 1) {
                if (Arrays.equals(s1Count, s2Count)) return true;
                s2Count[s2.charAt(i - (len1 - 1)) - 'a']--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        PermutationInString pis = new PermutationInString();
        System.out.println(pis.checkInclusion("ab", "eidbaooo"));
        System.out.println(pis.checkInclusion("ab", "eidboaoo"));
        System.out.println(pis.checkInclusion("a", "ab"));
    }
}
