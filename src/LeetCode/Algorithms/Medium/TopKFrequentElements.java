package LeetCode.Algorithms.Medium;
import java.util.*;
public class TopKFrequentElements {
    /*
        Runtime: 11 ms, faster than 55.50%
        Memory Usage: 42.2 MB, less than 9.48%
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        Integer[] result = map.keySet().toArray(new Integer[0]);
        int[] _result = new int[k];
        Arrays.sort(result, (a, b) -> map.get(b).compareTo(map.get(a)));
        if(result.length < k) {
            _result = new int[result.length];
            for(int i = 0; i < result.length; i++){
                _result[i] = result[i];
            }
        }else{
            for(int i = 0; i < _result.length; i++){
                _result[i] = result[i];
            }
        }
        return _result;
    }

    public static void main(String[] args){
        TopKFrequentElements te = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = te.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
