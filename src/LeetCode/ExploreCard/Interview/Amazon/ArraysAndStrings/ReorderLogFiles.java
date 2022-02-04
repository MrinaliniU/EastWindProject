package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.Arrays;

public class ReorderLogFiles {
    /*
        Runtime: 5 ms
        Memory Usage: 39.9 MB
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int compare = s1[1].compareTo(s2[1]);
                if(compare != 0) return compare;
                else return s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
    public static void main(String[] args){

    }
}
