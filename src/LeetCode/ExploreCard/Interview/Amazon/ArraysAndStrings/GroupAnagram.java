package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.*;
/*
    Runtime: 9 ms
    Memory Usage: 43 MB
 */
public class GroupAnagram {
    List<List<String>> groupAnagrams(String[] args){
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String s : args){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String _s = Arrays.toString(c);
            anagrams.putIfAbsent(_s, new ArrayList<>());
           anagrams.get(_s).add(s);
        }
       return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args){
        GroupAnagram ga = new GroupAnagram();
        List<List<String>> result = ga.groupAnagrams(new String[]{"eat", "cat"});
    }
}
