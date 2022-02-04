package LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> solution;
    int n;
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39.6 MB, less than 20.00%
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        solution = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(0, 0, sb);
        return solution;
    }

    void backTrack(int closingBrackets, int openingBrackets, StringBuilder sb){
        if(sb.length() == n * 2){
            solution.add(sb.toString());
            return;
        }
        if(openingBrackets < n){
            backTrack(closingBrackets, openingBrackets + 1, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closingBrackets < openingBrackets){
            backTrack(closingBrackets + 1, openingBrackets, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args){
        GenerateParentheses gp = new GenerateParentheses();
        for(String s : gp.generateParenthesis(3)){
            System.out.println(s);
        }
    }
}
