package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.*;
/* Do not underestimate the corner cases :
* - After the for loop the stack must be empty for a string to be valid. So return stack.isEmpty()
* - If you encounter a closing bracket, just checking if the stack.pop() is a
*   corresponding opening bracket is not enough. The stack could be empty, if so return false immediately.
* */
public class ValidParentheses {
    /*
        Runtime: 1 ms
        Memory Usage: 37.6 MB
     */
    public boolean isValid(String s) {
        /* The fancy way of keeping map did not improve runtime compared to your submission
        * in Easy folder of LeetCode */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int n = map.get(s.charAt(i));
            if(n > 0) stack.push(n);
            if(stack.isEmpty() || n < 0 && stack.pop() != Math.abs(n)) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        String s1 = "()"; // true
        String s2 = "()[]{}"; // true
        String s3 = "(]"; // false
        String s4 = "([)]"; // false
        String s5 = "{[]}"; // true
        String s6 = "]"; // false;
        System.out.println("Is Valid " + vp.isValid(s1));
        System.out.println("Is Valid " + vp.isValid(s2));
        System.out.println("Is Valid " + vp.isValid(s3));
        System.out.println("Is Valid " + vp.isValid(s4));
        System.out.println("Is Valid " + vp.isValid(s5));
        System.out.println("Is Valid " + vp.isValid(s6));
    }
}
