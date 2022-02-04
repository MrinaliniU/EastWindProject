package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import java.util.*;

/*
    Here two bfs is triggered one from begin node and other from end node.
     Also, two visited list is maintained for each of the two search.
    Termination condition for bidirectional
    search is finding a word which is already been seen by the parallel search.
 */
public class WordLadder_BiDirectional_BFS {





    static class Solution {
        private int L;
        private Map<String, List<String>> allComboDict;
        Solution() {
            this.L = 0;
            // Dictionary to hold combination of words that can be formed,
            // from any given word. By changing one letter at a time.
            this.allComboDict = new HashMap<>();
        }
        private int visitWordNode(Queue<Word> Q, Map<String, Integer> visited, Map<String, Integer> othersVisited) {
            Word node = Q.remove();
            String word = node.word;
            int level = node.level;
            for (int i = 0; i < this.L; i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (othersVisited.containsKey(adjacentWord)) {
                        return level + othersVisited.get(adjacentWord);
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        // Save the level as the value of the dictionary, to save number of hops.
                        visited.put(adjacentWord, level + 1);
                        Q.add(new Word(adjacentWord, level + 1));
                    }
                }
            }
            return -1;
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            // Since all words are of same length.
            this.L = beginWord.length();
            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            // Key is the generic word
                            // Value is a list of words which have the same intermediate generic word.
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            List<String> transformations =
                                    this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                            transformations.add(word);
                            this.allComboDict.put(newWord, transformations);
                        }
                    });
            // Queues for birdirectional BFS
            // BFS starting from beginWord
            Queue<Word> Q_begin = new LinkedList<>();
            // BFS starting from endWord
            Queue<Word> Q_end = new LinkedList<>();
            Q_begin.add(new Word(beginWord, 1));
            Q_end.add(new Word(endWord, 1));

            // Visited to make sure we don't repeat processing same word.
            Map<String, Integer> visitedBegin = new HashMap<>();
            Map<String, Integer> visitedEnd = new HashMap<>();
            visitedBegin.put(beginWord, 1);
            visitedEnd.put(endWord, 1);
            while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {
                // One hop from begin word
                int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
                if (ans > -1) {
                    return ans;
                }
                // One hop from end word
                ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
                if (ans > -1) {
                    return ans;
                }
            }
            return 0;
        }
    }
}
