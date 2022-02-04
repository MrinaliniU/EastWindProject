package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.*;

public class RansomNote {
    /*
        Runtime: 10 ms
        Memory Usage: 39.9 MB
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> _magazine_chars = new HashMap<>();
        HashMap<Character, Integer> _note_chars = new HashMap<>();
        for(char m : magazine.toCharArray()){
            _magazine_chars.put(m, _magazine_chars.getOrDefault(m, 0) + 1);
        }
        for(char n : ransomNote.toCharArray()){
            _note_chars.put(n, _note_chars.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : _note_chars.entrySet()){
            Character _n = entry.getKey(); Integer _i = entry.getValue();
            if(!_magazine_chars.containsKey(_n) || _magazine_chars.get(_n) < _i)
                return false;
        }
        return true;
    }
}
