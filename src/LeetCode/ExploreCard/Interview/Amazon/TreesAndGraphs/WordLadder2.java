package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
/* NOT SOLVED */
import java.util.*;
public class WordLadder2 {
    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        /* Form The Graph */
        HashMap<String, HashSet<String>> graph = getGraph(wordList);
        /* Queue to perform the BFS */
        Queue<Word> queue = new LinkedList<>();
        /* Track the words that have been visited to avoid cycle*/
        HashMap<String, Boolean> visited = new HashMap<>();
        /* We have to return the level of the endNode / endWord as that would represent
        the shortest sequence/distance from the beginWord. */
        queue.add(new Word(beginWord, 1, null));
        while (!queue.isEmpty()){
            Word curr_word = queue.poll();
            String word = curr_word.word; // the word
            int level = curr_word.level; // it's level
            visited.put(word, true); // mark as visited
            /* The neighbors of a word are all the words that can be formed by change in just one char
             * neighbors could be empty but not null*/
            HashSet<String> neighbors = getCommonWords(word, graph);
            /* For all neighbors --- > */
            for(String neighbor : neighbors) {
                if(visited.containsKey(neighbor)) continue; // if it's visited don't do anything
                if(neighbor.equals(endWord)) {
                    List<String> backtrack = backtrack(endWord, curr_word);
                    if(result.size() == 0 || backtrack.size() <= result.get(0).size()) result.add(backtrack);
                    break;
                }
                visited.put(neighbor, true);
                queue.add(new Word(neighbor, level + 1, curr_word)); // add the un-visited neighbor to bfs queue
            }
        }
        return result; // if transformation cannot be done from beginWord to endWord.
    }
    public List<String> backtrack(String endWord, Word currentWord){
        List<String> path = new ArrayList<>();
        path.add(endWord);
        while(currentWord != null){
            path.add(0, currentWord.word);
            currentWord = currentWord.parent;
        }
        return path;
    }
    public HashSet<String> getCommonWords(String word, HashMap<String, HashSet<String>> graph){
        HashSet<String> common = new HashSet<>();
        List<String> keys = getKeys(word);
        for(String k : keys){
            HashSet<String> s = graph.get(k);
            if(s != null) common.addAll(s);
        }
        return common;
    }
    public HashMap<String, HashSet<String>> getGraph(List<String> wordList){
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for(String s : wordList){
            List<String> key = getKeys(s);
            for(String k : key){
                graph.putIfAbsent(k, new HashSet<>());
                graph.get(k).add(s);
            }
        }
        return graph;
    }
    public List<String> getKeys(String word){
        List<String> result = new ArrayList<>();
        int len = word.length();
        for(int i = 0; i < len; i++){
            String s = word.substring(0, i) + "*" + word.substring(i + 1, len);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args){
        WordLadder2 wl = new WordLadder2();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        List<String> wordList2 = Arrays.asList("a", "b", "c");
        List<String> wordList3 = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        /*List<List<String>> result = wl.ladderLength("hit", "cog", wordList);
        for(List<String> r : result) System.out.println(r);*/

        /*List<List<String>> result2 = wl.ladderLength("a", "c", wordList2);
        for(List<String> r : result2) System.out.println(r);*/

        List<List<String>> result3 = wl.ladderLength("red", "tax", wordList3);
        for(List<String> r : result3) System.out.println(r);
        /*
            [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
         */
    }
}