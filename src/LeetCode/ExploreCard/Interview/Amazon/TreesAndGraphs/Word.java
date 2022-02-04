package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

public class Word {
    String word;
    Integer level;
    Word parent;
    Word(String word, int level){
        this.word = word;
        this.level = level;
    }
    Word(String word, int level, Word parent) {
        this.word = word;
        this.level = level;
        this.parent = parent;
    }
}
