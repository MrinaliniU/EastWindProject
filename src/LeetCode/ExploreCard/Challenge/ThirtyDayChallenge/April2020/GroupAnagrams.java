package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
import java.util.*;
public class GroupAnagrams {
    /* Sorting takes O(nlogn) time, to make it better instead of sorting we can check if the
    * count of each char in one string is equal to the count of each char in the other string. If and only
    * if and only if this is true then the two strings are anagrams
    * create a char[] of size 26 representing 26 alphabets.
    * Assumption made -
    * - All chars in string are lower case alphabets
    * For Each string increment count at the the index of each char of the string
    * create a substring with format <char><chars count> so "pat" will look like a1p1t1
    * See how the alphabets are sorted and have the count in front of them? They are sorted in o(n) time
    * because we are not actually sorting the chars but just reading the chars array and creating a string
    * since the chars array represents all alphabets in order the generated key is now sorted with char counts
    * This key can be used to store the strings from the main array into a HashMap. Note every anagram will have the same
    * key.*/
    /*
    Runtime: 26 ms
    Memory Usage: 53.9 MB
     */
    List<List<String>> groupAnagrams(String[] args){
        HashMap<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for(String s : args){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) count[c - 'a']++; // at respective char increment the number of time it is seen
            StringBuilder sb = new StringBuilder();
            for(int index = 0; index < count.length; index++){
                if(count[index] != 0) sb.append((char) (index + 'a')).append(count[index]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return (new ArrayList<>(map.values()));
    }
    // o(n) find if two strings are anagrams using sorting
    boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args){
        GroupAnagrams ga = new GroupAnagrams();
        //String[] arg = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] arg = {""};
        String[] arg = {"tea","","eat","","tea",""};
        //String[] arg = {"tao","pit","cam","aid","pro","dog"};
        List<List<String>> result = ga.groupAnagrams(arg);
        for(List<String> l : result){
            System.out.println(l);
        }
    }
}
