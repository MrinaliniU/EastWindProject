package LeetCode.Algorithms.Medium;
/*
    Runtime: 5 ms, faster than 87.30%
    Memory Usage: 39.5 MB, less than 50.00%
 */
import java.util.*;
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> word_count = new HashMap<>();
        for(String s : words){
            word_count.put(s, word_count.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>(word_count.keySet());
        // it is important that this is b - a ---> word_count.get(b) - word_count.get(a)
        // a - b would mean the smallest count comes first. But we want the one with highest count to come first.
        result.sort((a, b) ->
                word_count.get(a).equals(word_count.get(b)) ? a.compareTo(b) : word_count.get(b) - word_count.get(a));
        return k <= result.size() ? result.subList(0, k) : result;
    }
    public static void main(String[] args){
        TopKFrequentWords tk = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> result = tk.topKFrequent(words2, 4);
        System.out.println(result);
    }
}
