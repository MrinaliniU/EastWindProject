package Notes.Trees.Tries;

import java.util.TreeMap;

public class TrieNode {
    // Will hold all the chars under this node;
    TreeMap<Character, TrieNode> children = new TreeMap<>();
    private boolean isWord;
    private String word;

    public void setAsWord(String word) {
        this.word = word;
        this.isWord = true;
    }
    public boolean isWord() {
        return this.isWord;
    }
    public String getWord(){
        return this.word;
    }
}
