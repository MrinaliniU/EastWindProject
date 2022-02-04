package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.HashMap;
// Even though the logic is same the one thing to notice is a slight improvement in performance can
// be made to Java solution by using primitive arrays instead of Lists of HashMaps when possible.
public class FirstUniqueCharacterInString {
    /*
        Runtime: 7 ms. Better runtime.
        Memory Usage: 39.5 MB
     */
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) map[s.charAt(i) - 97]++;
        for(int i = 0; i < s.length(); i++) if(map[s.charAt(i) - 97] == 1) return i;
        return -1;
    }
/*
    Runtime: 22 ms
    Memory Usage: 40.5 MB
 */
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
    public static void main(String[] args){
        FirstUniqueCharacterInString fu = new FirstUniqueCharacterInString();
        String s1 = "loveleetcode";
        String s2 = "leetcode";
        System.out.println("Index " + fu.firstUniqChar(s1));
        System.out.println("Index " + fu.firstUniqChar(s2));
    }
}
