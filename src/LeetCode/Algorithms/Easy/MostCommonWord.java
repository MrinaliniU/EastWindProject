package LeetCode.Algorithms.Easy;

import java.util.*;

public class MostCommonWord {
    /*
        Runtime: 12 ms, faster than 50.24%
        Memory Usage: 39.5 MB, less than 5.05%
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        int max = 0;
        String result = "";
        String[] words = paragraph.trim().toLowerCase().split("\\P{Alpha}+");
        HashMap<String, Integer> word_count = new HashMap<>();
        List<String> _banned = new ArrayList<>();
        for(String b : banned)  _banned.add(b.toLowerCase());
        for(String word : words){
            if(_banned.contains(word)) continue;
            word_count.put(word, word_count.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : word_count.entrySet()){
            if(entry.getValue() > max) result = entry.getKey();
            max = Math.max(max, entry.getValue());

        }
        return result;
    }
    public static void main(String[] args){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        MostCommonWord mc = new MostCommonWord();
        System.out.println(mc.mostCommonWord(paragraph, banned));
    }
}
