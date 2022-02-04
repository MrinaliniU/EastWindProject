package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
    Runtime: 0 ms
    Memory Usage: 37.6 MB
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return backspace(S).equals(backspace(T));
    }

    public String backspace(String string){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            char s = string.charAt(i);
            if(s != '#') sb.append(s);
            else if(sb.length() >= 1) sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        BackspaceStringCompare bc = new BackspaceStringCompare();
        String S = "ab#c", T = "ad#c";
        String S1 = "ab##", T1 = "c#d#";
        String S2 = "a##c", T2 = "#a#c";
        String S3 = "a#c", T3 = "b";
        System.out.println(bc.backspaceCompare(S, T));
        System.out.println(bc.backspaceCompare(S1, T1));
        System.out.println(bc.backspaceCompare(S2, T2));
        System.out.println(bc.backspaceCompare(S3, T3));
    }
}
