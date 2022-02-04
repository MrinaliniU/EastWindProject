package LeetCode.Algorithms.Medium;

import java.util.ArrayList;
/*
    Runtime: 4 ms, faster than 69.41%
    Memory Usage: 41.8 MB, less than 5.37%
 */
public class ReverseWordsInAString {

    public String reverseWords(String s){
        int charPointer = 0;
        ArrayList<String> result = new ArrayList<>();
        while(charPointer < s.length()){
            if(s.charAt(charPointer) != ' '){
                StringBuilder temp = new StringBuilder();
                while(charPointer < s.length() && s.charAt(charPointer) != ' '){
                    temp.append(s.charAt(charPointer));
                    charPointer++;
                }
                result.add(temp.toString());
            }
            charPointer++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = result.size() - 1; i > 0; i--){
            sb.append(result.get(i)).append(" ");
        }
        if(result.size() > 0)
            sb.append(result.get(0));
        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "the sky is blue";// "blue is sky the" 15
        String s2 = "  hello world!  "; // "world! hello" 12
        String s3 = "a good   example"; // "example good a" 14
        String s4 = "     "; // "" 0
        String s5 = " 7"; // "7" 1
        String s6 = "A  B   C "; // "C B A" 5
        ReverseWordsInAString rs = new ReverseWordsInAString();
        String s11 = rs.reverseWords(s1);
        String s22 = rs.reverseWords(s2);
        String s33 = rs.reverseWords(s3);
        String s44 = rs.reverseWords(s4);
        String s55 = rs.reverseWords(s5);
        String s66 = rs.reverseWords(s6);
        System.out.println(s11 + " : " + s11.length());
        System.out.println(s22 + " : " + s22.length());
        System.out.println(s33 + " : " + s33.length());
        System.out.println(s44 + " : " + s44.length());
        System.out.println(s55 + " : " + s55.length());
        System.out.println(s66 + " : " + s66.length());
    }
}
