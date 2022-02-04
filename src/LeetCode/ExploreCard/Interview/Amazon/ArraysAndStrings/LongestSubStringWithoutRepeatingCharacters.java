package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
/*
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a SUBSEQUENCE and not a SUBSTRING.
IMPORTANT : Try forming logic with "dvdf" string.
 */
import java.util.*;
public class LongestSubStringWithoutRepeatingCharacters {
    /*
        Better solution below Crazy ass DP solution,
        Runtime: 13 ms, faster than 22.18%
        Memory Usage: 41.5 MB, less than 5.20%
    */
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for(int index = 0; index < s.length(); index++){
            char a = s.charAt(index);
            int lastSeenIndex = map.getOrDefault(a, -1);
            start = Math.max(start, lastSeenIndex + 1); // this will only increment when you see a dup char
            max = Math.max(max, index - start + 1); // len of substring from start to index
            map.put(a, index); // update the char in hashmap with it's last seen index
        }
        return max;
    }
    /*
        Same DP as above but much better performance
        Runtime: 5 ms, faster than 86.94%
        Memory Usage: 40.8 MB, less than 5.44%
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] lastSeenIndex = new int[128];
        Arrays.fill(lastSeenIndex, -1);
        int max = 0, start = 0;
        for (int index = 0; index < s.length(); index++) {
            char a = s.charAt(index);
            start = Math.max(start, lastSeenIndex[a] + 1);
            max = Math.max(max, index - start + 1);
            lastSeenIndex[a] = index; // update the last seen index of char a
        }
        return max;
    }

    /*
        Runtime: 19 ms, faster than 20.35%
        Memory Usage: 43 MB, less than 5.20%
     */
    public int lengthOfLongestSubstring3(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = s.length();
        // Sliding window tracked by left and right
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < length && left < length){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    /*
        O(n2) Runtime: 323 ms
              Memory Usage: 114.3 MB
     */
    public int lengthOfLongestSubstring4(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int j = i;
            while(j < s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                length += 1;
                j++;
            }
            set.clear();
            max = Math.max(max, length);
            length = 0;
        }
        return max;
    }


    public static void main(String[] args){
        LongestSubStringWithoutRepeatingCharacters r = new LongestSubStringWithoutRepeatingCharacters();
        String s1 = "abcabcbb"; //3
        String s2 = "bbbbb"; // 1
        String s3 = "pwwkew"; // 3
        String s4 = "dvdf"; // 3
        String s5 = ""; // 0
        String s6 = " "; // 1
        String s7 = "abba";
        System.out.println(r.lengthOfLongestSubstring1(s3));
    }
}
