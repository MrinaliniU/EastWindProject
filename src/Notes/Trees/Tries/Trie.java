package Notes.Trees.Tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public List<String> getWordsNStartingFrom(String s, int n){
        TrieNode current = root;
        List<String> result = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(current.children.containsKey(c)) current = current.children.get(c);
            else return result;
        }
        dfs(result, current, n);
        return result;
    }
    private void dfs(List<String> result, TrieNode node, int limit){
        if(result.size() == limit) return;
        if(node.isWord()) result.add(node.getWord());
        for(TrieNode child : node.children.values()){
            dfs(result, child, limit);
        }
    }
    public boolean hasWord(String s){
        TrieNode current = root;
        for(char c : s.toCharArray()){
            if(current.children.containsKey(c)) current = current.children.get(c);
            else return false;
        }
        return current.isWord();
    }
    public void insertWord(String s){
        TrieNode current = this.root;
        for(char c : s.toCharArray()){
            if(!current.children.containsKey(c)) current.children.put(c, new TrieNode());
            current = current.children.get(c);
        }
        current.setAsWord(s);
    }

}
