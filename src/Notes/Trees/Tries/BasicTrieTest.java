package Notes.Trees.Tries;

import java.util.List;

public class BasicTrieTest {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insertWord("mobile");
        trie.insertWord("mouse");
        trie.insertWord("moneypot");
        trie.insertWord("monitor");
        trie.insertWord("mousepad");
        trie.insertWord("bags");
        trie.insertWord("baggage");
        trie.insertWord("banner");
        trie.insertWord("box");
        trie.insertWord("cloths");
        trie.insertWord("havana");
        System.out.println("Trie has word mo - " + trie.hasWord("mo"));
        System.out.println("Trie has word mobileytfgh - " + trie.hasWord("mobileytfgh"));
        String subString = "tatina";
        System.out.println("get max 3 words starting from " + subString);
        List<String> result1 = trie.getWordsNStartingFrom(subString, 3);
        System.out.println(result1);
    }
}
