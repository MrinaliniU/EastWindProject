package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
    Runtime: 9 ms
    Memory Usage: 37.5 MB
 */
import java.util.*;
import java.util.stream.Collectors;

public class CountingElements {
    public int countElements(int[] arr) {
        int count = 0;
        List<Integer> arr1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> arr2 = new ArrayList<>();
        for(int i : arr1) arr2.add(i + 1);
        for(int j : arr2) count += arr1.contains(j) ? 1 : 0;
        return count;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        CountingElements ce = new CountingElements();
        System.out.println(ce.countElements(arr));
    }
}
