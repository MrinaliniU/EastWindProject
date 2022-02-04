package LeetCode.ExploreCard.Interview.Amazon.Recursion;

import java.util.*;
/*
    Runtime: 16 ms
    Memory Usage: 49.1 MB
 */
public class WordSearch2 {
    static class TrieNode{
        // All chars under this node
        Map<Character, TrieNode> children;
        private boolean isWord;
        private String word;
        TrieNode(){
            children = new HashMap<>();
        }
        public void setWord(String word) {
            this.word = word;
            this.isWord = true;
        }
    }
    static class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void insert(String s){
            TrieNode current = this.root;
            for(char c : s.toCharArray()){
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.setWord(s);
        }
    }
    List<String> result;
    char[][] board;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        result = new ArrayList<>();

        /* BUILD TRIE */
        Trie dictionary = new Trie();
        for(String word : words) dictionary.insert(word);
        TrieNode root = dictionary.root;
        /* TRAVERSE THE BOARD */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.children.containsKey(board[i][j]))
                    backTrack(i, j, root);
            }
        }
        return result;
    }

    public void backTrack(int row, int col, TrieNode parent){
        Character charOnBoard = board[row][col];
        TrieNode childNode = parent.children.get(charOnBoard);
        if(childNode.isWord){
            result.add(childNode.word); // solution
            // removes cases where you got dog and when you look for dogs you wont add dog again to solution
            childNode.isWord = false;
        }
        board[row][col] = '#';
        for (int[] direction : directions){
            int r = row + direction[0], c = col + direction[1];
            if(!isValid(r, c)) continue;
            if(childNode.children.containsKey(board[r][c])) backTrack(r, c, childNode); // backtrack
        }
        board[row][col] = charOnBoard; // restore
        // optimization by pruning leaf nodes of trie
        if(childNode.children.isEmpty()) // means it is a leaf
            parent.children.remove(charOnBoard);
    }

    public boolean isValid(int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }

    public static void main(String[] args){
        WordSearch2 w2 = new WordSearch2();
        char[][] board = {{'a','b'},{'a','a'}};
        String[] words = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        List<String> result = w2.findWords(board, words);
        System.out.print(result);
    }
}
