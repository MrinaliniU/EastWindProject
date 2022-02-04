package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
// import javafx.util.Pair;
/* Leetcode uses Java Pair util, I'm unable to resolve the dependency here so creating a
class called word */

import java.util.*;
public class WordLadder_OneDirectional_BFS {
    /* O(M×N) M is the length of the word and N is the number of words in the wordList
    *   Runtime: 59 ms, faster than 58.15%
        Memory Usage: 47.7 MB, less than 5.11%
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* Form The Graph */
        HashMap<String, HashSet<String>> graph = getGraph(wordList);
        /* Queue to perform the BFS */
        Queue<Word> queue = new LinkedList<>();
        /* Track the words that have been visited to avoid cycle*/
        HashMap<String, Boolean> visited = new HashMap<>();
        /* We have to return the level of the endNode / endWord as that would represent
        the shortest sequence/`distance from the beginWord. */
        queue.add(new Word(beginWord, 1));
        visited.put(beginWord, true); // mark as visited
        while (!queue.isEmpty()) {
            Word curr_word = queue.poll();
            String word = curr_word.word; // the word
            int level = curr_word.level; // it's level
            /* The neighbors of a word are all the words that can be formed by change in just one char
             * neighbors could be empty but not null*/
            HashSet<String> neighbors = getCommonWords(word, graph);
            /* For all neighbors --- > */
            for (String neighbor : neighbors) {
                if (visited.containsKey(neighbor)) continue; // if it's visited don't do anything
                if (neighbor.equals(endWord)) return level + 1; // if the end word is found return it's level
                visited.put(neighbor, true);
                queue.add(new Word(neighbor, level + 1)); // add the un-visited neighbor to bfs queue
            }
        }
        return 0; // if transformation cannot be done from beginWord to endWord.
    }

    /* The neighbors of a word are all the words that can be formed by change in just one char.
     * - Say we are looking at "hot", it has keys "*ot", "h*t", "ho*".
     * - Each key has associated list of words that can be formed from that key. Like
     *   "*ot" : "dot", "lot", "hot"
     *   "h*t" : "hit", "hot"
     *   "ho*" " "hog", "hot"
     * - Notice how "dot", "lot", "hit" and "hog" are all now immediate neighbors of "hot"
     * - getCommonWords would return a set of "dot", "lot", "hit", "hog" and "hot"
     * - Notice how "hot" itself is marked as it's neighbor. The visited boolean list
     *   will take care of not adding "hot" again in the bfs queue.
     * */
    public HashSet<String> getCommonWords(String word, HashMap<String, HashSet<String>> graph) {
        HashSet<String> common = new HashSet<>();
        List<String> keys = getKeys(word);
        for (String k : keys) {
            HashSet<String> s = graph.get(k);
            if (s != null) common.addAll(s);
        }
        return common;
    }

    /*
    The graph is formed in this format :
     - for every word say "hot" all one-word transformation keys are formed like so:
        "*ot", "h*t", "ho*".
     - these are added as keys in the graph and for each key HashSet of all words that has this intermittent
       states are added. For example "*ot" can have a word "dot" added to it's HashSet.
    * */
    public HashMap<String, HashSet<String>> getGraph(List<String> wordList) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for (String s : wordList) {
            List<String> key = getKeys(s);
            for (String k : key) {
                graph.putIfAbsent(k, new HashSet<>());
                graph.get(k).add(s);
            }
        }
        return graph;
    }

    public List<String> getKeys(String word) {
        List<String> result = new ArrayList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            String s = word.substring(0, i) + "*" + word.substring(i + 1, len);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        WordLadder_OneDirectional_BFS wl = new WordLadder_OneDirectional_BFS();
        /*List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        int level = wl.ladderLength("hit", "cog", wordList);*/
        List<String> wordList = Arrays.asList("a", "b", "c");
        int level = wl.ladderLength("a", "c", wordList);
        System.out.println(level);
    }

}