package CrackingTheCodingInterview.DataStructures.ArraysAndStrings_1;

/*
	Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco cta", etc").
*/

import java.util.*;

public class PalindromePermutation_4 {
    boolean isPalindromePermutation(String input){
        input = input.trim().toUpperCase();
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isLetter(c)) continue;
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int flag = 0;
        for(int i : charMap.values()){
            if(i % 2 != 0) flag++;
            if(flag > 1) return false;
        }
        return true;
    }


    public static void main(String[] args){
        String input = " &%56   90 abc 00&&";
        String string = "Tact Coa";
        PalindromePermutation_4 p4 = new PalindromePermutation_4();
        System.out.println("The string is a palindrome permutation " + p4.isPalindromePermutation(input));
    }
}
