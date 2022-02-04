package HackerRank.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a list of numbers find a subset s such that the subset has the maximum numbers of which sum of
    no two numbers in s is divisible by k */
public class NonDivisibleSubset {

    private static int nonDivisibleSubset(int k, List<Integer> s) {
        /* Create an array counting frequency of remainders for all digits in list s*/
        int[] remainderFrequency = new int[k];
        Arrays.fill(remainderFrequency, 0);
        for (Integer integer : s) {
            remainderFrequency[integer % k]++;
        }
        /* remainderFrequency[0] counts the number of Integers divisible by k. We just need one of these numbers */
        int result = Math.min(remainderFrequency[0], 1);
        /* if k is even number */
        if(k % 2 == 0)
            remainderFrequency[k/2] = Math.min(remainderFrequency[k/2], 1);
        for(int i = 1; i <= k/2; i++){
            result += Math.max(remainderFrequency[i], remainderFrequency[k - i]);
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> s = new ArrayList<>(Arrays.asList(278, 576, 496, 727, 410,
                124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
        int result = nonDivisibleSubset(7, s);
        System.out.println(result);

    }
}
