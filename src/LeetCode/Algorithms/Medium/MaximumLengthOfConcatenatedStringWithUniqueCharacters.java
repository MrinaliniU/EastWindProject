package LeetCode.Algorithms.Medium;

/*
    Problem No. 1239.
 */

import java.util.*;
/*
    Runtime: 20 ms, faster than 47.57%
    Memory Usage: 41.5 MB, less than 100.00%
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    // TODO: 3/4/2020 #MyInterviews.Microsoft #backtracking #bitmanipulation
    int lengthOfSubString = 0;
    public int maxLength(List<String> arr){
        depthFirstRecursion(arr, "", 0);
        return lengthOfSubString;
    }

    public void depthFirstRecursion(List<String> arr, String subString, int index){
        if(!isUnique(subString)) return;
        if(subString.length() > lengthOfSubString) lengthOfSubString = subString.length();
        for(int i = index; i < arr.size(); i++){
            depthFirstRecursion(arr, subString + arr.get(i), index + 1);
        }
    }

    public boolean isUnique(String s){
        HashSet<Character> charSet = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(!charSet.add(c)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        List<String> arr2 = new ArrayList<>();
        arr2.add("cha");
        arr2.add("r");
        arr2.add("act");
        arr2.add("ers");
        List<String> arr3 = new ArrayList<>();
        arr3.add("abcdefghijklmnopqrstuvwxyz");
        MaximumLengthOfConcatenatedStringWithUniqueCharacters mc = new MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        System.out.println(mc.maxLength(arr));
    }
}
