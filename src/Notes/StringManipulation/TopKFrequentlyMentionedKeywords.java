package Notes.StringManipulation;
import java.util.*;
// TODO: 4/6/2020 $Amazon #good-code

/* comparision of string is NOT case-sensitive */
public class TopKFrequentlyMentionedKeywords {
    public List<String> topKFrequent(int k, String[] reviews, String[] keywords) {
        Map<String, Integer> keyword_count = new HashMap<>();
        ArrayList<ArrayList<String>> _reviews = new ArrayList<>();
        // Change the structure of reviews such that each review is stored as
        // array of chars containing only alphabetic words.
        // turned it to lowercase as well god knows what the run time is
        for(String r : reviews){
            _reviews.add(new ArrayList<>(Arrays.asList(r.toLowerCase().split("\\P{Alpha}+"))));
        }
        // for each keyword check it occurs in how many reviews "NOT how many times it occurs
        for (String keyword : keywords) {
            for (ArrayList<String> review : _reviews) {
                if (review.contains(keyword))
                    keyword_count.put(keyword, keyword_count.getOrDefault(keyword, 0) + 1);
            }
        }
        List<String> ls = new ArrayList<>(keyword_count.keySet());
        ls.sort((a, b) -> keyword_count.get(a).equals(keyword_count.get(b)) ? a.compareTo(b) : keyword_count.get(b) - keyword_count.get(a));

        return k < ls.size() ? ls.subList(0, k) : ls;
    }
    public static void main(String[] args){
        TopKFrequentlyMentionedKeywords tk = new TopKFrequentlyMentionedKeywords();
        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",};

        List<String> result = tk.topKFrequent(3, reviews, keywords);
        System.out.println(result);
    }
}
