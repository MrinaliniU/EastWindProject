package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.*;
/*
    Runtime: 39 ms, faster than 34.86%
    Memory Usage: 57 MB, less than 15.38%
 */
class ImplementTrie {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        String word;

        TrieNode() {
            this.children = new HashMap<>();
        }

    }

    static class Trie {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode current = this.root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isWord = true;
            current.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode current = this.root;
            for (char c : word.toCharArray()) {
                if (current.children.isEmpty() || !current.children.containsKey(c)) return false;
                current = current.children.get(c);
            }
            return current.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode current = this.root;
            for (char c : prefix.toCharArray()) {
                if (current.children.isEmpty() || !current.children.containsKey(c)) return false;
                current = current.children.get(c);
            }
            return true;

        }
    }
}
