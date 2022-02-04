package LeetCode.Algorithms.Medium;

import java.util.*;
/** Trie data structure coded in my Notes package can be used but I'm re-writing it here for
 * practice and for leetcode of course*/
/*
    Runtime: 52 ms, faster than 22.63%
    Memory Usage: 46.7 MB, less than 100.00%
 */
public class SearchSuggestionsSystem {
    static class TrieNode{
        TreeMap<Character, TrieNode> children = new TreeMap<>();
        boolean isWord;
        String word;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        /* Create Trie */
        TrieNode root = new TrieNode();
        for(String s : products){
            insertWord(s, root);
        }
        for(int i = 1; i <= searchWord.length(); i++){
            /*List<String> r = getSimilarWords(searchWord.substring(0, i), root, 3);
           if(!r.isEmpty()) result.add(r);*/
            result.add(getSimilarWords(searchWord.substring(0, i), root, 3));
        }
        return result;
    }
    public void insertWord(String s, TrieNode root){
        TrieNode current = root;
        for(char c : s.toCharArray()){
            if(!current.children.containsKey(c)) current.children.put(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
        current.word = s;
    }
    public List<String> getSimilarWords(String s, TrieNode root, int limit){
        TrieNode current = root;
        List<String> result = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(current.children.containsKey(c)) current = current.children.get(c);
            else return result;
        }
        dfs(current, limit, result);
        return result;
    }
    public void dfs(TrieNode node, int limit, List<String> result){
        if(result.size() == limit) return;
        if(node.isWord) result.add(node.word);
        for(TrieNode c : node.children.values()){
            dfs(c, limit, result);
        }
    }

    public static void main(String[] args){
        String[] products1 = {
                "mobile","mouse","moneypot","monitor","mousepad"
        };
        String searchWord1 = "mouse";
        String[] products2 = {
                "havana"
        };
        String searchWord2 = "havana";
        String[] products3 = {
                "bags","baggage","banner","box","cloths"
        };
        String searchWord3 = "bags";
        String[] products4 = {
                "havana"
        };
        String searchWord4 = "tatiana";
        SearchSuggestionsSystem ss = new SearchSuggestionsSystem();
        List<List<String>> result = ss.suggestedProducts(products4, searchWord4);
        for(List<String> r : result){
           System.out.println(r);
        }

    }
}
