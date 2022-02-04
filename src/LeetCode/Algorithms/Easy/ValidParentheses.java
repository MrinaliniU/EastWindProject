package LeetCode.Algorithms.Easy;

import java.util.Stack;

/*
    Problem No. 20.
 */
public class ValidParentheses {

    /*
        Runtime: 1 ms, faster than 98.74%
        Memory Usage: 37.3 MB, less than 5.06%
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String openingBrackets = "{([";
        String closingBracket = "})]";
        for(int i = 0; i < s.length(); i++){
            if(openingBrackets.indexOf(s.charAt(i)) >= 0) stack.add(s.charAt(i));
            else{
                if(stack.isEmpty()) return false;
                if(closingBracket.indexOf(s.charAt(i)) != openingBrackets.indexOf(stack.pop()))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        //String s = "{[()}]"; //false
        //String s = "()";
        // String s = "()[]{}";
        // String s = "(]";
        // String s = "([)]";
         // String s = "{[]}";
        String s = "]";
       System.out.println("The given String " + s + " is a valid parentheses string " + vp.isValid(s));
    }
}

