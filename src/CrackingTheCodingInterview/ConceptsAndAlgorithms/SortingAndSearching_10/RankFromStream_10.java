package CrackingTheCodingInterview.ConceptsAndAlgorithms.SortingAndSearching_10;

import java.util.*;

public class RankFromStream_10 {
    /* Try with custom tree data structure */
    TreeMap<Integer, Integer> arrayStore = new TreeMap<>();

    public void track(int x){
        int count = arrayStore.getOrDefault(x, 0);
        arrayStore.put(x, count + 1);
    }
    public int getRankOfNumber(int x){
        int count = 0;
        for(Map.Entry<Integer, Integer> map : arrayStore.entrySet()){
            if(map.getKey() > x) break;
            count += map.getValue();
        }
        return count - 1;
    }

    public static void main(String[] args){
        RankFromStream_10 r10 = new RankFromStream_10();
        r10.track(5);
        r10.track(1);
        r10.track(4);
        r10.track(4);
        r10.track(5);
        r10.track(9);
        r10.track(7);
        r10.track(13);
        r10.track(3);
        System.out.println("Get Rank of 1 " + r10.getRankOfNumber(1));
        System.out.println("Get Rank of 1 " + r10.getRankOfNumber(3));
        System.out.println("Get Rank of 1 " + r10.getRankOfNumber(4));
    }
}
