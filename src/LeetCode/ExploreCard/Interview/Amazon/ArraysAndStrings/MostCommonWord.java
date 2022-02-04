package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.*;

public class MostCommonWord {
    /*
        Runtime: 12 ms
        Memory Usage: 39.7 MB
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.trim().toLowerCase().split("\\P{Alpha}+");
        HashMap<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;
        List<String> _banned = Arrays.asList(banned);
        /* O(n) */
        for(String word : words){
            if(!_banned.contains(word)){
                int i = map.getOrDefault(word, 0) + 1;
                max = Math.max(max, i);
                map.put(word, i);
            }
        }
        /* O(n) */
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == max) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
