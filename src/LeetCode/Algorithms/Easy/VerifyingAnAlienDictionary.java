package LeetCode.Algorithms.Easy;

import java.util.*;

public class VerifyingAnAlienDictionary {
    /*
        Runtime: 5 ms, faster than 7.15%
        Memory Usage: 39.4 MB, less than 7.69%
     */
    public boolean isAlienSorted_Stupid_Solution(String[] words, String order) {
        String[] _words = new String[words.length];
        System.arraycopy(words, 0, _words, 0, words.length);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int pos1 = 0;
                int pos2 = 0;
                for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
                    pos1 = order.indexOf(o1.charAt(i));
                    pos2 = order.indexOf(o2.charAt(i));
                }

                if (pos1 == pos2 && o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                return pos1  - pos2  ;
            }
        });
        return Arrays.equals(_words, words);
    }
    public static void main(String[] args){
        VerifyingAnAlienDictionary a = new VerifyingAnAlienDictionary();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words2 = {"word","world","row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        String[] words3 = {"apple","app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(a.isAlienSorted_Stupid_Solution(words, order));
        System.out.println(a.isAlienSorted_Stupid_Solution(words2, order2));
        System.out.println(a.isAlienSorted_Stupid_Solution(words3, order3));
    }
}
