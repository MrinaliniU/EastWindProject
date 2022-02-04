package Notes.Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithSumK {

    public int numberOfSubArray(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int numberOfSubArrays = 0;
        int intermittentSum = 0;
        for(int a : arr){
            intermittentSum += a;
            if(map.containsKey(intermittentSum - k))
                numberOfSubArrays += map.get(intermittentSum - k);
            map.put(intermittentSum, map.getOrDefault(intermittentSum, 0) + 1);
        }
        return numberOfSubArrays;
    }

    public static void main(String[] args){
        int[] arr = {5, 4, 7, 11, 2, 22, 5, 4, 3, 10};
        int k = 22;
        NumberOfSubArraysWithSumK nsa = new NumberOfSubArraysWithSumK();
        System.out.println("The number of sub arrays with sum " + k + " is " + nsa.numberOfSubArray(arr, k));
    }
}
