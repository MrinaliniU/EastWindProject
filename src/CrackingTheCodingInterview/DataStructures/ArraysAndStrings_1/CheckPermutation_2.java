package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

/*
    Given two strings, write a method to decide if one is a permutation of the
other.
 */

import java.util.Arrays;

public class CheckPermutation_2 {

    public boolean isPermutationBySort(String word1, String word2){
        if(word1.length() != word2.length()) return false;
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        Arrays.sort(word1Chars);
        Arrays.sort(word2Chars);
        word1 = new String(word1Chars);
        word2 = new String(word2Chars);
        return word1.equals(word2);
    }

    public boolean isPermutationEfficient(String word1, String word2){
        if (word1.length() != word2.length()) return false;
        int[] charCountCache = new int[128];
        for(int i = 0; i < word1.length(); i++){
            charCountCache[(int) word1.charAt(i)]++;
            charCountCache[(int) word2.charAt(i)]++;
        }
        for (int value : charCountCache) {
            if (value % 2 != 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        CheckPermutation_2 checkPermutation_2 = new CheckPermutation_2();
        if(checkPermutation_2.isPermutationEfficient("ggg", "gge"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
