package LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    List<String> solution;
    List<List<Character>> phone;
    /*
        Runtime: 1 ms, faster than 79.81%
        Memory Usage: 38.8 MB, less than 6.16%
     */
    public List<String> letterCombinations(String digits) {
        solution = new ArrayList<>();
        phone = new ArrayList<>();
        phone.add(new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        phone.add(new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        phone.add(new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        phone.add(new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        phone.add(new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        phone.add(new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        phone.add(new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        phone.add(new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        backTrack(0, "", digits);
        return solution;
    }
    void backTrack(int row, String sb, String digits){
        if(sb.length() == digits.length()) {
            solution.add(sb);
            return;
        }
        List<Character> letters = phone.get(digits.charAt(row) - '0' - 2);
        for(int col = 0; col < letters.size(); col++){
            backTrack(row + 1, sb + letters.get(col), digits);
        }
    }

    public static void main(String[] args){
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        String digits = "23";
        for(String s : l.letterCombinations(digits)) System.out.println(s);

    }
}
