package GooglePrep.CodeJam.Y2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestingDepth {
/* Passed the given tests but failed hidden tests **/
    public static String nesting(String array){
        if(array == null || array.length() == 0) return array;
        StringBuilder sb = new StringBuilder();
        List<Integer> numberOfParentheses = new ArrayList<>();
        for(int i = 0; i < array.length(); i++){
            int currentDigit = array.charAt(i) - '0';
            int left = i - 1 < 0 ? currentDigit : Math.max(0, currentDigit - (array.charAt(i - 1) - '0'));
            int right = i + 1 >= array.length() ? currentDigit : Math.max(0, currentDigit - (array.charAt(i + 1) - '0'));
            numberOfParentheses.add(left);
            numberOfParentheses.add(right);
        }

        for(int i = 0; i < array.length(); i++){
            addLeftParentheses(sb, numberOfParentheses.get(i + i));
            sb.append(array.charAt(i));
            addRightParentheses(sb, numberOfParentheses.get(i + i + 1));
        }
        return sb.toString();
    }
    public static void addLeftParentheses(StringBuilder sb, int n){
        while (n != 0){
            sb.append("(");
            n--;
        }
    }
    public static void addRightParentheses(StringBuilder sb, int n){
        while (n != 0){
            sb.append(")");
            n--;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for(int i = 0; i < tests; i++){
            String result = nesting(in.next());
            System.out.println("Case #" + i + ": " + result);
        }
    }
/*    public static void main(String[] args){
        String input = "312";
        long startTime = System.nanoTime();
        System.out.println(nesting(input));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000000000); // nanoseconds
    }*/
}
