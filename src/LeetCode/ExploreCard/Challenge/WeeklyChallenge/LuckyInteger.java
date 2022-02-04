package LeetCode.ExploreCard.Challenge.WeeklyChallenge;

import java.util.*;

public class LuckyInteger {

    public int findLucky(int[] arr){
        int maxLucky = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key.equals(value) && value > maxLucky) maxLucky = value;
        }
        return maxLucky;
    }
    public static void main(String[] args){
        int[] array1 = {2, 2, 3, 4};
        int[] array2 = {1, 2, 2, 3, 3, 3};
        int[] array3 = {2, 2, 2, 3, 3};
        int[] array4 = {1};
        int[] array5 = {7, 7, 7, 7, 7, 7, 7};
        LuckyInteger li = new LuckyInteger();
        System.out.println("ans1 " + li.findLucky(array1));
        System.out.println("ans2 " + li.findLucky(array2));
        System.out.println("ans3 " + li.findLucky(array3));
        System.out.println("ans4 " + li.findLucky(array4));
        System.out.println("ans5 " + li.findLucky(array5));
    }
}
