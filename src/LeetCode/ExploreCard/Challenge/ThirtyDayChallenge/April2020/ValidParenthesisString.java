package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

/* Not my Solution */
public class ValidParenthesisString {
    /* Two iteration to validate the string
    *   - When passing from left - right consider * to be opening bracket and check if it is a
    *       valid string. Increment for every opening and decrement for every closing.
    *       If any point the count becomes -ve it means the string is invalid. Return false.
    *   - At the end of first iteration if count is 0 it means we got a balanced string
    *       by simply replacing all * with an opening bracket. This is good enough to prove
    *       the string is balanced. Return true.
    *   - However, this count could be a higher positive number. This is when you will need to
    *       check a second iteration from right to left of the string.
    *   - You now start from the end of the string and consider * to be a closing bracket.
    *   - Increment count for every * or closing bracket and decrement for an opening bracket.
    *   - At anytime you encounter a -ve count it indicates an imbalanced string so return false
    *   - At the end if no imbalance is seen it is a valid string return true.
    * Note : At the end of both iteration the count could be +ve number greater than 0 it
    * just indicates the additional *s that were simply not needed to form a valid parenthesis string.*/
/*
    Runtime: 0 ms
    Memory Usage: 37.2 MB
 */
    public boolean checkValidString(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='(' || c == '*') count++;
            else count--;
            if(count < 0) return false;
        }
        if(count == 0) return true;
        count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(s.charAt(i) == ')' || c == '*') count++;
            else count--;
            if(count < 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String input = "(*()"; // true
        String input2 = "((*)"; // true
        String input3 = "(*()"; // true
        String input4 = "((()))()(())(*()()())**(())()()()()((*()*))((*()*)"; // true
        String input5 = "***((()"; // false
        ValidParenthesisString vs = new ValidParenthesisString();
        System.out.println("Is valid " + vs.checkValidString(input));
        System.out.println("Is valid " + vs.checkValidString(input2));
        System.out.println("Is valid " + vs.checkValidString(input3));
        System.out.println("Is valid " + vs.checkValidString(input4));
        System.out.println("Is valid " + vs.checkValidString(input5));
    }
}
