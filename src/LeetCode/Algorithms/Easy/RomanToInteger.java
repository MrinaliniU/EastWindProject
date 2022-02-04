package LeetCode.Algorithms.Easy;

import java.util.HashMap;

public class RomanToInteger {

    /*
        Runtime: 7 ms, faster than 27.77%
        Memory Usage: 42.2 MB, less than 5.48%
     */
    public int romanToInt(String s){
        HashMap<String, Integer> map = getRomanLetter();
        int sum = 0;
        int i = 0;
        while(i < s.length()){
            if(i + 1 < s.length() && map.get(s.substring(i, i + 2)) != null){
                sum += map.get(s.substring(i, i + 2));
                i = i + 2;
            }else{
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }

    public HashMap<String, Integer> getRomanLetter(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);
        return hashMap;
    }
    public static void main(String[] args){
        //String s = "MCMXCIV";
        // String s = "LVIII";
        String s = "I";
        RomanToInteger ri = new RomanToInteger();
        int result = ri.romanToInt(s);
        System.out.println(s + " is - " + result);
    }
}
