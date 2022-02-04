package Notes.Recursion.Medium;

import java.util.ArrayList;

public class PowerSetOfAString {

    private static void powerSetOfString(String word, int index, ArrayList<String> result, String current){
        int length = word.length();
        if(index == length) return;
        result.add(current);
        for(int i = index + 1; i < length; i++){
            current += word.charAt(i);
            powerSetOfString(word, i, result, current);
            current = current.substring(0, current.length() - 1);
        }
    }

    public static void main(String[] args){
        ArrayList<String> result = new ArrayList<String>();
        powerSetOfString("abc", -1, result, "");
        for(String s : result){
            System.out.print("\"" + s + "\" ");
        }
    }
}
