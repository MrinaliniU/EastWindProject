package MyInterviews.Bloomberg;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallestSentenceWithAllkeywords {

    static List<Integer> returnNumberOfkeyWord(List<String> paragraph, List<String> keywords){
        List<Integer> keywrdIndex = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        String finalString = "";
        for(String x : paragraph){
            finalString += x;
            finalString = finalString + " ";
        }
        for(String s : keywords){
            int index = paragraph.indexOf(s);
            if(index >= 0){
                keywrdIndex.add(index);
            }

        }

        int lastItem = keywrdIndex.size() - 1;
        result.add(keywrdIndex.get(0));
        result.add(keywrdIndex.get(lastItem));

        return result;

    }
    public static void main(String args[] ) throws Exception {
        List<String> para = new ArrayList<String>(Arrays.asList("I", "have", "a", "cat", "and", "a", "dog", "and", "cat"));
        List<String> key = new ArrayList<String>(Arrays.asList("cat", "dog"));

        List<Integer> result = returnNumberOfkeyWord(para, key);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}